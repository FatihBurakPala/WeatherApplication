package com.android.weatherapplication.repository

import com.android.weatherapplication.api.ApiService
import com.android.weatherapplication.model.WeatherData
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Response
import javax.inject.Inject

@ViewModelScoped
class WeatherRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getWeather(cityName: String): Response<WeatherData> {
        return apiService.getWeather(cityName)
    }
}
