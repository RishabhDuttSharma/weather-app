package com.assignment.weatherapp.util.ext

import com.assignment.weatherapp.data.AppConstant
import com.assignment.weatherapp.data.TruncateDecimalPlaces

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */

fun Double.toTruncatedDecimalString(
    @TruncateDecimalPlaces
    decimalPlaces: Int = TruncateDecimalPlaces.DEFAULT
) = String.format("%.${decimalPlaces}f", this)

fun String.toTemperatureInC() = "$this${AppConstant.TEMPERATURE_IN_C}"
