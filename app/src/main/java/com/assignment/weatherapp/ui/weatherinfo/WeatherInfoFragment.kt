package com.assignment.weatherapp.ui.weatherinfo

import android.os.Bundle
import com.assignment.weatherapp.R
import com.assignment.weatherapp.data.AppConstant
import com.assignment.weatherapp.databinding.FragmentWeatherInfoBinding
import com.assignment.weatherapp.ui.BaseFragment

class WeatherInfoFragment :
    BaseFragment<FragmentWeatherInfoBinding>(R.layout.fragment_weather_info) {

    override fun initComponents(savedInstanceState: Bundle?, binding: FragmentWeatherInfoBinding) {
        // retrieve view-model
        getViewModel<WeatherInfoViewModel>().apply {
            binding.viewModel = this
            infoBinder.countryCode = AppConstant.COUNTRY_CODE_INDIA
        }.also {
            it.onZipCodeSubmitted("122018")
        }
    }
}