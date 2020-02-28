package com.assignment.weatherapp.data

import androidx.annotation.IntDef
import com.assignment.weatherapp.data.TruncateDecimalPlaces.Companion.DEFAULT
import com.assignment.weatherapp.data.TruncateDecimalPlaces.Companion.TEMPERATURE

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
object AppConstant {

    const val ABSOLUTE_ZERO_DEGREE_KELVIN = 273.15

    const val TEMPERATURE_IN_C = "°C"

    const val COUNTRY_CODE_INDIA = "IN"
}

@IntDef(DEFAULT, TEMPERATURE)
annotation class TruncateDecimalPlaces {
    companion object {
        const val DEFAULT = 2
        const val TEMPERATURE = 1
    }
}