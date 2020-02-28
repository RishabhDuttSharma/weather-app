package com.assignment.weatherapp.util.ext

import com.assignment.weatherapp.data.Result


/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
fun <T> Result<T>.onResponse(success: (T) -> Unit, error: ((Exception) -> Unit)? = null) =
    when (this) {
        is Result.Success -> success(data)
        is Result.Error -> error?.invoke(exception)
    }