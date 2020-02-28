package com.assignment.weatherapp.data.source.remote

import com.assignment.weatherapp.BuildConfig
import com.assignment.weatherapp.data.WeatherInfo
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/13/2020
 */
interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun getZipCodeWeatherData(
        @Query("zip") zipcode: String,
        @Query("appid") appid: String = BuildConfig.OPEN_WEATHER_MAP_API_KEY
    ): List<WeatherInfo>
}