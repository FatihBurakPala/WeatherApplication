package com.android.weatherapplication.domain.source

import com.android.weatherapplication.data.dto.WeatherResponse

interface RemoteDataSource {

    suspend fun getWeather(cityName: String): WeatherResponse
}
