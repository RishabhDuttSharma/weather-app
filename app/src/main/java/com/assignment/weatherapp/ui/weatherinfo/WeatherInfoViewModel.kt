package com.assignment.weatherapp.ui.weatherinfo

import com.assignment.weatherapp.data.source.IWeatherRepository
import com.assignment.weatherapp.ui.BaseViewModel
import javax.inject.Inject

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
class WeatherInfoViewModel @Inject constructor(
    private val repository: IWeatherRepository
) : BaseViewModel() {

    val todoBinder = WeatherInfoBinder()
}
