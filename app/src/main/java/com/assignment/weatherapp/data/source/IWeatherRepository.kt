package com.assignment.weatherapp.data.source

import com.assignment.weatherapp.data.Result
import com.assignment.weatherapp.data.WeatherInfo


/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
interface IWeatherRepository {

    /**
     * Retrieves weather data from Web-Api-Server
     */
    suspend fun getCurrentWeatherData(zipCode: String): Result<List<WeatherInfo>>

}