package com.android.weatherapplication.api

import com.android.weatherapplication.model.WeatherData
import com.android.weatherapplication.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getWeather(
        @Query("q") cityName: String
    ): Response<WeatherData>
}
