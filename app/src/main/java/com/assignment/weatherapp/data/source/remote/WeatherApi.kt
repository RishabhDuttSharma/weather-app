package com.assignment.weatherapp.data.source.remote

import com.assignment.weatherapp.BuildConfig
import com.assignment.weatherapp.data.WeatherInfo
import com.assignment.weatherapp.data.WeeklyForecast
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun getZipCodeWeatherData(
        @Query("zip") zipcode: String,
        @Query("appid") appid: String = BuildConfig.OPEN_WEATHER_MAP_API_KEY
    ): WeatherInfo

    @GET("data/2.5/forecast")
    suspend fun getZipCodeWeeklyForecast(
        @Query("zip") zipcode: String,
        @Query("appid") appid: String = BuildConfig.OPEN_WEATHER_MAP_API_KEY
    ): WeeklyForecast
}