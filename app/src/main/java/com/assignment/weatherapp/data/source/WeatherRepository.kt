package com.assignment.weatherapp.data.source

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
class WeatherRepository(private val dataSource: WeatherDataSource) : IWeatherRepository {

    override suspend fun getCurrentWeatherData(zipCode: String) =
        dataSource.getCurrentWeatherData(zipCode)
}