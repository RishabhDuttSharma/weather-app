package com.assignment.weatherapp.ui.weatherinfo

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.kennyc.view.MultiStateView

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
class WeatherInfoBinder : BaseObservable() {

    // can be initialized (or configured) for different countries
    var countryCode: String = ""

    @get:Bindable
    var icon: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.icon)
        }

    @get:Bindable
    var currentTemperatureInC: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.currentTemperatureInC)
        }

    @get:Bindable
    var currentTemperatureDescription: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.currentTemperatureDescription)
        }

    @get:Bindable
    var temperatureMinMax: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.temperatureMinMax)
        }


    @get:Bindable
    var multiViewState: MultiStateView.ViewState = MultiStateView.ViewState.EMPTY
        set(value) {
            field = value
            notifyPropertyChanged(BR.multiViewState)
        }
    @get:Bindable
    var weeklyItemsLoading: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.weeklyItemsLoading)
        }
}