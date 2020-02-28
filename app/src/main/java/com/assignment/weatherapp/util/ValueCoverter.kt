package com.assignment.weatherapp.util

import com.assignment.weatherapp.data.AppConstant

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */

interface ValueConverter<in T, out R> {

    fun convert(value: T): R
}

class KelvinToCelciusConverter : ValueConverter<Double, Double> {

    override fun convert(value: Double) =
        value - AppConstant.ABSOLUTE_ZERO_DEGREE_KELVIN
}