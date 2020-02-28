package com.assignment.weatherapp.data.source

import com.assignment.weatherapp.data.Result
import com.assignment.weatherapp.data.WeatherInfo
import com.assignment.weatherapp.data.WeeklyForecast

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
interface WeatherDataSource {

    suspend fun getCurrentWeatherData(zipCode: String): Result<WeatherInfo>

    suspend fun getForecastWeeklyData(zipCode: String): Result<WeeklyForecast>
}