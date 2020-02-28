package com.assignment.weatherapp.data.source.remote

import com.assignment.weatherapp.data.Result
import com.assignment.weatherapp.data.WeatherInfo
import com.assignment.weatherapp.data.source.WeatherDataSource
import com.assignment.weatherapp.util.ext.toErrorResult
import timber.log.Timber

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
class WeatherRemoteDataSource(private val weatherApi: WeatherApi) : WeatherDataSource {

    override suspend fun getCurrentWeatherData(zipCode: String): Result<List<WeatherInfo>> = try {
        // attempt web-api-call, and map to success-result
        Result.Success(weatherApi.getZipCodeWeatherData(zipCode))
    } catch (ex: Exception) {
        with(ex) {
            // log error
            Timber.e(this)
            // map to error-result
            toErrorResult()
        }
    }
}