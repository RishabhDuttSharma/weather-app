package com.assignment.weatherapp.data

import com.squareup.moshi.Json

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
data class WeatherInfo(
    @field:Json(name = "coord") val coordinates: Coordinates,
    @field:Json(name = "weather") val weather: List<Weather>,
    @field:Json(name = "base") val base: String,
    @field:Json(name = "main") val main: Main,
    @field:Json(name = "visibility") val visibility: Long,
    @field:Json(name = "wind") val wind: Wind,
    @field:Json(name = "clouds") val clouds: Clouds,
    @field:Json(name = "dt") val date: Long,
    @field:Json(name = "sys") val systemInfo: SystemInfo,
    @field:Json(name = "timezone") val timezone: Long,
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "cod") val code: Int
)

data class Coordinates(
    @field:Json(name = "lon") val lon: Double,
    @field:Json(name = "lat") val lat: Double
)


data class Weather(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "main") val main: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "icon") val icon: String
)

data class Main(
    @field:Json(name = "temp") val temp: Double,
    @field:Json(name = "feels_like") val feelsLike: Double,
    @field:Json(name = "temp_min") val tempMin: Double,
    @field:Json(name = "temp_max") val tempMax: Double,
    @field:Json(name = "pressure") val pressure: Double,
    @field:Json(name = "humidity") val humidity: Double
)

data class Wind(
    @field:Json(name = "speed") val speed: Double,
    @field:Json(name = "deg") val deg: Int
)

data class Clouds(
    @field:Json(name = "all") val all: Int
)

data class SystemInfo(
    @field:Json(name = "type") val type: Int,
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "message") val message: Double,
    @field:Json(name = "country") val country: String,
    @field:Json(name = "sunrise") val sunrise: Long,
    @field:Json(name = "sunset") val sunset: Long
)

