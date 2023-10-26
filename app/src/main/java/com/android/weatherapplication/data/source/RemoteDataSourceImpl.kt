package com.android.weatherapplication.data.source

import com.android.weatherapplication.data.dto.WeatherResponse
import com.android.weatherapplication.domain.source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class RemoteDataSourceImpl(private val apiService: ApiService): RemoteDataSource {

    override suspend fun getWeather(cityName: String): WeatherResponse {
        return apiService.getWeather(cityName)
    }
}
