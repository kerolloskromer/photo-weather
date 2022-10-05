package com.kromer.domain.features.weather.usecases

import com.kromer.domain.base.usecases.SuspendUseCase
import com.kromer.domain.features.weather.models.Weather
import com.kromer.domain.features.weather.models.WeatherRequestParams
import com.kromer.domain.features.weather.repository.WeatherRepository
import com.kromer.domain.utils.Resource

class GetWeatherUseCase(
    private val repository: WeatherRepository,
) : SuspendUseCase<WeatherRequestParams, Resource<Weather>> {
    override suspend fun invoke(params: WeatherRequestParams): Resource<Weather> =
        repository.getWeather(params)
}