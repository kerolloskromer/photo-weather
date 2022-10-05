package com.kromer.data.features.weather.datasource.remote

import com.kromer.data.features.weather.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiInterface {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat: Double?,
        @Query("lon") lon: Double?,
        @Query("units") units: String,
    ): WeatherResponse
}