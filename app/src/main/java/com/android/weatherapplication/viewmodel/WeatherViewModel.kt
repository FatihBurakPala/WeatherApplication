package com.android.weatherapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.weatherapplication.model.WeatherData
import com.android.weatherapplication.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository): ViewModel() {

    private val _getAllWeather = MutableLiveData<WeatherData>()
    val getAllWeather: LiveData<WeatherData> = _getAllWeather

    val loading = MutableLiveData<Boolean>()

    fun getWeather(cityName: String) = viewModelScope.launch {

        loading.postValue(true)

        weatherRepository.getWeather(cityName).let { response ->
            if (response.isSuccessful) {
                _getAllWeather.postValue(response.body())
            } else {
                Log.d("TAG", response.code().toString())
            }
        }
        loading.postValue(false)
    }
}
