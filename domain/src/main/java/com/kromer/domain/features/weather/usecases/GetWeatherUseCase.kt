package com.kromer.domain.features.weather.usecases

import com.kromer.domain.base.usecases.SuspendUseCase
import com.kromer.domain.features.location.usecases.GetLocationUseCase
import com.kromer.domain.features.weather.models.Weather
import com.kromer.domain.features.weather.models.WeatherRequestParams
import com.kromer.domain.features.weather.repository.WeatherRepository
import com.kromer.domain.utils.Resource

class GetWeatherUseCase(
    private val repository: WeatherRepository,
    private val getLocationUseCase: GetLocationUseCase,
) : SuspendUseCase<Unit, Resource<Weather?>> {
    override suspend fun invoke(params: Unit): Resource<Weather?> {
        val location = getLocationUseCase(Unit).data
        val weatherRequestParams = location?.let {
            // For temperature in Celsius use units=metric
            WeatherRequestParams(it.latitude, it.longitude, "metric")
        } ?: WeatherRequestParams(0.0, 0.0, "")
        return repository.getWeather(weatherRequestParams)
    }
}