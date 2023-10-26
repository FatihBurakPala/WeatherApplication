package com.android.weatherapplication.presentation.weather

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.weatherapplication.R
import com.android.weatherapplication.databinding.FragmentWeatherBinding
import com.android.weatherapplication.common.CheckNetwork.isOnline
import com.android.weatherapplication.common.viewBinding
import com.android.weatherapplication.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment(R.layout.fragment_weather) {

    private val binding by viewBinding(FragmentWeatherBinding::bind)
    private val viewModel: WeatherViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            searchButton.setOnClickListener {
                val cityInput = editTextCity.text.toString()

                if(cityInput.isNotEmpty()) {
                    if(isOnline(requireContext())) {
                        viewModel.getWeather(cityInput)
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

            viewModel.getAllWeather.observe(viewLifecycleOwner) { weatherData ->
                cityText.text = weatherData.name
                descriptionText.text = weatherData.weather.first().description
                tempText.text = "Temperature: ${weatherData.main.temp}°C"
                pressureText.text = "Pressure: ${weatherData.main.pressure}"
                humidityText.text = "Humidity: ${weatherData.main.humidity}"
                coordTexts.text = "${weatherData.coord.lat} / ${weatherData.coord.lon}"
                weatherImage.loadImage(weatherData.weather.first().icon)
            }

            viewModel.loading.observe(viewLifecycleOwner) {
                if (it) {
                    progressBar.visibility = View.VISIBLE
                } else {
                    progressBar.visibility = View.GONE
                }
            }
        }
    }
}
