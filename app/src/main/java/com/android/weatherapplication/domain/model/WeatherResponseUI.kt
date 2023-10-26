package com.android.weatherapplication.domain.model

data class WeatherResponseUI(
    val name: String,
    val main: MainUI,
    val coord: CoordinateUI,
    val weather: List<WeatherUI>
)
