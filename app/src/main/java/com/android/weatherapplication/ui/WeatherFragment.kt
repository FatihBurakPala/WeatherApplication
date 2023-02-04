package com.android.weatherapplication.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.weatherapplication.databinding.FragmentWeatherBinding
import com.android.weatherapplication.utils.CheckNetwork.isOnline
import com.android.weatherapplication.viewmodel.WeatherViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    private val weatherViewModel: WeatherViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentWeatherBinding.inflate(inflater, container, false)

        binding.apply {

            /* -----------------------------------Search Button----------------------------------- */
            searchButton.setOnClickListener {
                val cityInput = editTextCity.text.toString()

                if(cityInput.isNotEmpty()) {
                    if(isOnline(requireContext())) {
                        weatherViewModel.getWeather(cityInput)
                    } else {
                        Toast.makeText(
                            activity,
                            "Please check your internet connection",
                            Toast.LENGTH_SHORT).show()
                    }
                }
                editTextCity.text.clear()
                editTextCity.onEditorAction(EditorInfo.IME_ACTION_DONE)
            }

            /* -----------------------------------Network Data----------------------------------- */
            weatherViewModel.getAllWeather.observe(viewLifecycleOwner) { weatherData ->

                cityText.text = weatherData.name
                descriptionText.text = weatherData.weather[0].description
                tempText.text = "Temperature: ${weatherData.main.temp}°C"
                pressureText.text = "Pressure: ${weatherData.main.pressure}"
                humidityText.text = "Humidity: ${weatherData.main.humidity}"
                coordTexts.text = "${weatherData.coord.lat} / ${weatherData.coord.lon}"

                val weatherIcon = weatherData.weather[0].icon
                Glide.with(this@WeatherFragment)
                    .load("http://openweathermap.org/img/wn/$weatherIcon@2x.png")
                    .into(weatherImage)
            }
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
