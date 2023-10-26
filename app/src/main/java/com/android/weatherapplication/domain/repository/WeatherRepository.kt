package com.android.weatherapplication.domain.repository

import com.android.weatherapplication.domain.model.WeatherResponseUI

interface WeatherRepository {

    suspend fun getWeather(cityName: String): WeatherResponseUI
}
