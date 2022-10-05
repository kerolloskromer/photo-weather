package com.kromer.data.features.weather.mappers

import com.kromer.data.features.weather.models.WeatherResponse
import com.kromer.domain.base.mappers.ModelMapper
import com.kromer.domain.features.weather.models.Weather

class WeatherMapper : ModelMapper<WeatherResponse, Weather> {
    override fun mapFrom(from: WeatherResponse): Weather {
        return Weather(
            from.coord.lat,
            from.coord.lon,
            from.dt,
            from.main.temp,
            from.main.humidity,
            from.main.pressure,
            from.weather.firstOrNull()?.description ?: "",
            from.weather.firstOrNull()?.icon ?: "",
        )
    }
}