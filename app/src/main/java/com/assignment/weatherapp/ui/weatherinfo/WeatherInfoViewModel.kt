package com.assignment.weatherapp.ui.weatherinfo

import androidx.lifecycle.viewModelScope
import com.assignment.weatherapp.data.TruncateDecimalPlaces
import com.assignment.weatherapp.data.WeatherInfo
import com.assignment.weatherapp.data.source.IWeatherRepository
import com.assignment.weatherapp.ui.BaseViewModel
import com.assignment.weatherapp.util.KelvinToCelciusConverter
import com.assignment.weatherapp.util.ext.onResponse
import com.assignment.weatherapp.util.ext.toTemperatureInC
import com.assignment.weatherapp.util.ext.toTruncatedDecimalString
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
class WeatherInfoViewModel @Inject constructor(
    private val repository: IWeatherRepository
) : BaseViewModel() {

    val infoBinder = WeatherInfoBinder()

    fun loadWeatherInfo(zipCode: String) {
        viewModelScope.launch {
            repository.getCurrentWeatherData(zipCode).onResponse(::handleSuccess)
        }
    }

    private fun handleSuccess(weatherInfo: WeatherInfo) {
        infoBinder.icon = weatherInfo.weather.firstOrNull()?.icon

        weatherInfo.main.let { tempInfo ->

            infoBinder.currentTemperatureDescription = weatherInfo.weather.firstOrNull()?.main

            with(KelvinToCelciusConverter()) {

                infoBinder.currentTemperatureInC = convert(tempInfo.temp)
                    .toTruncatedDecimalString(TruncateDecimalPlaces.TEMPERATURE)
                    .toTemperatureInC()

                val minTempInC = convert(tempInfo.tempMin).toInt()
                val maxTempInC = convert(tempInfo.tempMax).toInt()

                infoBinder.temperatureMinMax = String.format("%d / %d ", minTempInC, maxTempInC)
                    .toTemperatureInC()
            }
        }
    }
}
