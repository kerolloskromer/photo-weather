package com.kromer.domain.features.weather.models

data class WeatherRequestParams(
    val lat: Double,
    val lon: Double,
    val units: String,
)