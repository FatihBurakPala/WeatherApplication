package com.android.weatherapplication.data.repository

import com.android.weatherapplication.data.mapper.toWeatherResponseUI
import com.android.weatherapplication.domain.model.WeatherResponseUI
import com.android.weatherapplication.domain.repository.WeatherRepository
import com.android.weatherapplication.domain.source.RemoteDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow

@ViewModelScoped
class WeatherRepositoryImpl(private val remoteDataSource: RemoteDataSource): WeatherRepository {

    override suspend fun getWeather(cityName: String): WeatherResponseUI {
        return remoteDataSource.getWeather(cityName).toWeatherResponseUI()
    }
}
