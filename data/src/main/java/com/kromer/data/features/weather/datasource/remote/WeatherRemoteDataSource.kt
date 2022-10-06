package com.kromer.data.features.weather.datasource.remote

import com.kromer.data.features.weather.models.WeatherResponse
import com.kromer.domain.features.weather.models.WeatherRequestParams

interface WeatherRemoteDataSource {
    suspend fun getWeather(request: WeatherRequestParams): WeatherResponse
}