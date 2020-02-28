package com.assignment.weatherapp.util.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
inline fun <reified T : ViewModel> ViewModelStoreOwner.getViewModel(
    factory: ViewModelProvider.Factory? = null
): T = if (factory == null) {
    ViewModelProvider(this)
} else {
    ViewModelProvider(this, factory)
}[T::class.java]