package com.kromer.domain.features.weather.models

data class Weather(
    val lat: Double,
    val lon: Double,
    val timestamp: Long,
    val temp: Float,
    val humidity: Float,
    val pressure: Float,
    val description: String,
    val icon: String,
)