package com.assignment.weatherapp.ui.weatherinfo

import android.os.Bundle
import androidx.fragment.app.commitNow
import com.assignment.weatherapp.R
import com.assignment.weatherapp.databinding.ActivityWeatherInfoBinding
import com.assignment.weatherapp.ui.BaseActivity

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
class WeatherInfoActivity :
    BaseActivity<ActivityWeatherInfoBinding>(R.layout.activity_weather_info) {

    override fun initComponents(savedInstanceState: Bundle?, binding: ActivityWeatherInfoBinding) {
        savedInstanceState ?: supportFragmentManager.commitNow {
            replace(R.id.container, WeatherInfoFragment())
        }
    }
}