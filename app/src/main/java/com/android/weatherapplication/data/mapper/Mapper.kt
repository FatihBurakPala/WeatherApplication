package com.android.weatherapplication.data.mapper

import com.android.weatherapplication.data.dto.Coordinate
import com.android.weatherapplication.data.dto.Main
import com.android.weatherapplication.data.dto.Weather
import com.android.weatherapplication.data.dto.WeatherResponse
import com.android.weatherapplication.domain.model.CoordinateUI
import com.android.weatherapplication.domain.model.MainUI
import com.android.weatherapplication.domain.model.WeatherResponseUI
import com.android.weatherapplication.domain.model.WeatherUI

fun WeatherResponse.toWeatherResponseUI() = WeatherResponseUI(
    name = name,
    main = main.toMainUI(),
    coord = coord.toCoordinateUI(),
    weather = weather.map { it.toWeatherUI() }
)

fun Main.toMainUI() = MainUI(
    humidity = humidity,
    pressure = pressure,
    temp = temp
)

fun Coordinate.toCoordinateUI() = CoordinateUI(
    lat = lat,
    lon = lon
)

fun Weather.toWeatherUI() = WeatherUI(
    description = description,
    icon = icon
)
