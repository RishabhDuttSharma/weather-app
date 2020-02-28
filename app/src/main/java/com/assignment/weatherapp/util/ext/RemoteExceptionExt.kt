package com.assignment.weatherapp.util.ext

import com.assignment.weatherapp.data.Result
import java.net.UnknownHostException

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/20/2020
 */

fun <T> Exception.toErrorResult() = Result.Error<T>(
    Exception(
        when (this) {
            is UnknownHostException -> "No internet connection!"
            else -> "Something went wrong"
        }
    )
)