package com.kromer.data.features.weather.datasource.remote

import com.kromer.data.features.weather.models.WeatherResponse
import com.kromer.domain.features.weather.models.WeatherRequestParams

class WeatherRemoteDataSourceImpl(
    private val weatherApiInterface: WeatherApiInterface
) : WeatherRemoteDataSource {
    override suspend fun getWeather(request: WeatherRequestParams): WeatherResponse =
        weatherApiInterface.getWeather(request.lat, request.lon, request.units)
}