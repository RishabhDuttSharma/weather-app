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
import com.kennyc.view.MultiStateView
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

    private fun loadWeatherInfo(zipCode: String) {
        viewModelScope.launch {
            // display loading view
            infoBinder.multiViewState = MultiStateView.ViewState.LOADING

            val zipCodeWithCountry = zipCode + "," + infoBinder.countryCode
            repository.getCurrentWeatherData(zipCodeWithCountry)
                .onResponse(::handleSuccess, ::handleError)
        }
    }


    private fun handleSuccess(weatherInfo: WeatherInfo) {
        // display content view
        infoBinder.multiViewState = MultiStateView.ViewState.CONTENT

        infoBinder.icon = weatherInfo.weather.firstOrNull()?.icon

        weatherInfo.main.let { tempInfo ->

            infoBinder.currentTemperatureDescription = weatherInfo.weather.firstOrNull()?.main

            with(KelvinToCelciusConverter()) {

                infoBinder.currentTemperatureInC = convert(tempInfo.temp)
                    .toTruncatedDecimalString(TruncateDecimalPlaces.TEMPERATURE)
                    .toTemperatureInC()

                val minTempInC = convert(tempInfo.tempMin)
                    .toTruncatedDecimalString(TruncateDecimalPlaces.TEMPERATURE)

                val maxTempInC = convert(tempInfo.tempMax)
                    .toTruncatedDecimalString(TruncateDecimalPlaces.TEMPERATURE)

                infoBinder.temperatureMinMax = String.format("%s / %s ", minTempInC, maxTempInC)
                    .toTemperatureInC()
            }
        }
    }

    private fun handleError(error: Exception) {
        error.printStackTrace()

        // display error view
        infoBinder.multiViewState = MultiStateView.ViewState.ERROR
    }

    fun onZipCodeSubmitted(zipCode: String) = loadWeatherInfo(zipCode)
}
