package com.android.weatherapplication.presentation.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.weatherapplication.domain.model.WeatherResponseUI
import com.android.weatherapplication.domain.use_case.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val useCase: WeatherUseCase): ViewModel() {

    private val _getAllWeather = MutableLiveData<WeatherResponseUI>()
    val getAllWeather: LiveData<WeatherResponseUI> = _getAllWeather

    val loading = MutableLiveData<Boolean>()

    fun getWeather(cityName: String) = viewModelScope.launch {
        loading.postValue(true)
        useCase(cityName).let {
            _getAllWeather.postValue(it)
        }
        loading.postValue(false)
    }
}
