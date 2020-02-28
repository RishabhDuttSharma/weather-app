package com.assignment.weatherapp.data

import com.squareup.moshi.Json

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
data class WeatherInfo(
    @Json(name = "coord") val coordinates: Coordinates,
    @Json(name = "weather") val weather: List<Weather>,
    @Json(name = "base") val base: String,
    @Json(name = "main") val main: Main,
    @Json(name = "visibility") val visibility: Long,
    @Json(name = "wind") val wind: Wind,
    @Json(name = "clouds") val clouds: Clouds,
    @Json(name = "dt") val date: Long,
    @Json(name = "sys") val systemInfo: SystemInfo,
    @Json(name = "timezone") val timezone: Long,
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "cod") val code: Int
)

data class Coordinates(
    @Json(name = "lon") val lon: Double,
    @Json(name = "lat") val lat: Double
)


data class Weather(
    @Json(name = "id") val id: Long,
    @Json(name = "main") val main: String,
    @Json(name = "description") val description: String,
    @Json(name = "icon") val icon: String
)

data class Main(
    @Json(name = "temp") val temp: Double,
    @Json(name = "feels_like") val feelsLike: Double,
    @Json(name = "temp_min") val tempMin: Double,
    @Json(name = "temp_max") val tempMax: Double,
    @Json(name = "pressure") val pressure: Double,
    @Json(name = "humidity") val humidity: Double
)

data class Wind(
    @Json(name = "speed") val speed: Double,
    @Json(name = "deg") val deg: Int
)

data class Clouds(
    @Json(name = "all") val all: Int
)

data class SystemInfo(
    @Json(name = "type") val type: Int,
    @Json(name = "id") val id: Long,
    @Json(name = "message") val message: Double,
    @Json(name = "country") val country: String,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long
)

