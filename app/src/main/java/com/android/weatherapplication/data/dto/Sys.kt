package com.android.weatherapplication.data.dto

data class Sys(
    val country: String,
    val sunrise: Int,
    val sunset: Int,
    val id: Int?,
    val type: Int?
)
