package com.android.weatherapplication.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(weatherIcon: String) {
    Glide.with(this.context)
        .load("http://openweathermap.org/img/wn/$weatherIcon@2x.png")
        .into(this)
}
