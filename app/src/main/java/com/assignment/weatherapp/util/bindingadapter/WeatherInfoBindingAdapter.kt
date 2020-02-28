package com.assignment.weatherapp.util.bindingadapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.assignment.weatherapp.BuildConfig
import com.squareup.picasso.Picasso

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */

@BindingAdapter("icon")
fun bindWeatherIcon(imageView: AppCompatImageView, icon: String) {
    Picasso.get().load("${BuildConfig.BASE_URL}/img/w/${icon}.png").into(imageView)
}