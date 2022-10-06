package com.kromer.data.features.weather.mappers

import android.content.Context
import android.location.Address
import android.location.Geocoder
import com.kromer.data.features.weather.models.WeatherResponse
import com.kromer.domain.base.mappers.UniModelMapper
import com.kromer.domain.features.weather.models.Weather
import java.util.*

class WeatherMapper(
    private val context: Context
) : UniModelMapper<WeatherResponse, Weather> {
    override fun mapFrom(from: WeatherResponse): Weather {
        val geocoder = Geocoder(context, Locale.getDefault())
        val addresses: List<Address> = geocoder.getFromLocation(from.coord.lat, from.coord.lon, 1)
        val address: String = addresses[0].getAddressLine(0) ?: ""
        return Weather(
            from.coord.lat,
            from.coord.lon,
            address,
            from.dt,
            from.main.temp,
            from.main.humidity,
            from.main.pressure,
            from.weather.firstOrNull()?.description ?: "",
            from.weather.firstOrNull()?.icon ?: "",
        )
    }
}