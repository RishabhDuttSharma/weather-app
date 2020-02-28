package com.assignment.weatherapp.util.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.assignment.weatherapp.R
import com.assignment.weatherapp.util.Utils
import com.squareup.picasso.Picasso

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */

@BindingAdapter("weatherIcon")
fun bindWeatherIcon(imageView: ImageView, weatherIcon: String?) {
    with(Picasso.get()) {
        if (weatherIcon != null) {
            load(Utils.getWeatherIconUrl(weatherIcon))
        } else load(R.drawable.ic_weather)
    }.placeholder(R.drawable.ic_weather).into(imageView)
}
