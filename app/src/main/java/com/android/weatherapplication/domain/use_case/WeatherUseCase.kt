package com.android.weatherapplication.domain.use_case

import com.android.weatherapplication.domain.model.WeatherResponseUI
import com.android.weatherapplication.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(cityName: String): WeatherResponseUI {
        return repository.getWeather(cityName)
    }
}
