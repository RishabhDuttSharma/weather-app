package com.assignment.weatherapp.ui.weatherinfo

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.viewModelScope
import com.assignment.weatherapp.R
import com.assignment.weatherapp.data.ForecastItem
import com.assignment.weatherapp.data.TruncateDecimalPlaces
import com.assignment.weatherapp.data.WeatherInfo
import com.assignment.weatherapp.data.WeeklyForecast
import com.assignment.weatherapp.data.source.IWeatherRepository
import com.assignment.weatherapp.ui.BaseViewModel
import com.assignment.weatherapp.util.KelvinToCelciusConverter
import com.assignment.weatherapp.util.ext.onResponse
import com.assignment.weatherapp.util.ext.toTemperatureInC
import com.assignment.weatherapp.util.ext.toTruncatedDecimalString
import com.kennyc.view.MultiStateView
import kotlinx.coroutines.launch
import me.tatarka.bindingcollectionadapter2.BR
import me.tatarka.bindingcollectionadapter2.ItemBinding
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

    val forecastItems = ObservableArrayList<ForecastItem>()
    val forecastItemBinding = ItemBinding.of<ForecastItem>(
        BR.forecastItem, R.layout.adapter_forecast_item
    )

    private fun loadWeatherInfo(zipCode: String) {
        viewModelScope.launch {
            // display loading view
            infoBinder.multiViewState = MultiStateView.ViewState.LOADING

            val zipCodeWithCountry = zipCode + "," + infoBinder.countryCode
            repository.getCurrentWeatherData(zipCodeWithCountry)
                .onResponse(::handleSuccess, ::handleError)
        }
    }

    private fun loadForecastData(zipCode: String) {
        viewModelScope.launch {
            // display loading view
            infoBinder.weeklyItemsLoading = true

            val zipCodeWithCountry = zipCode + "," + infoBinder.countryCode
            repository.getWeeklyForecastData(zipCodeWithCountry)
                .onResponse(::handleForecastSuccess, ::handleError)
        }
    }

    private fun handleForecastSuccess(weeklyForecast: WeeklyForecast) {

        val forecastItemsList = weeklyForecast.list.map {
            val temperature = KelvinToCelciusConverter().convert(it.main.temp)
                .toTruncatedDecimalString(TruncateDecimalPlaces.TEMPERATURE)
                .toTemperatureInC()

            ForecastItem(temperature, "28-02-2020")
        }

        forecastItems.clear()
        forecastItems.addAll(forecastItemsList)
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

    fun onZipCodeSubmitted(zipCode: String) {
        loadWeatherInfo(zipCode)
        loadForecastData(zipCode)
    }
}