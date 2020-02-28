package com.assignment.weatherapp.util

import com.assignment.weatherapp.BuildConfig

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
object Utils {

    fun getWeatherIconUrl(icon: String) = "${BuildConfig.BASE_URL}/img/w/${icon}.png"
}