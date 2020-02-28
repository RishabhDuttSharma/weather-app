package com.assignment.weatherapp.data

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()

    data class Error<T>(val exception: Exception) : Result<T>()

}