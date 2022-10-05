package com.kromer.data.features.weather.repository

import com.kromer.data.base.BaseRepositoryImpl
import com.kromer.data.features.weather.datasource.remote.WeatherRemoteDataSource
import com.kromer.data.features.weather.mappers.WeatherMapper
import com.kromer.domain.base.mappers.mapFromWith
import com.kromer.domain.features.weather.models.Weather
import com.kromer.domain.features.weather.models.WeatherRequestParams
import com.kromer.domain.features.weather.repository.WeatherRepository
import com.kromer.domain.utils.Resource

class WeatherRepositoryImpl(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val weatherMapper: WeatherMapper,
) : WeatherRepository, BaseRepositoryImpl() {
    override suspend fun getWeather(request: WeatherRequestParams): Resource<Weather> =
        safeCall { weatherRemoteDataSource.getWeather(request).mapFromWith(weatherMapper) }
}