package com.android.weatherapplication.data.source

import com.android.weatherapplication.data.dto.WeatherResponse
import com.android.weatherapplication.common.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getWeather(
        @Query("q") cityName: String
    ): WeatherResponse
}
