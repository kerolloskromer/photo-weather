package com.kromer.domain.features.weather.repository

import com.kromer.domain.features.weather.models.Weather
import com.kromer.domain.features.weather.models.WeatherRequestParams
import com.kromer.domain.utils.Resource

interface WeatherRepository {
    suspend fun getWeather(request: WeatherRequestParams): Resource<Weather>
}