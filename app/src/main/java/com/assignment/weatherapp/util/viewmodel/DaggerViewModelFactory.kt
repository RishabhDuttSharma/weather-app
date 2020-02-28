package com.nagarro.assignment.util.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/14/2020
 */
class DaggerViewModelFactory @Inject constructor(
    private val viewModelProvidersMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val viewModelProvider = viewModelProvidersMap[modelClass]
            ?: viewModelProvidersMap.asIterable().firstOrNull { (viewModelClass, _) ->
                modelClass.isAssignableFrom(viewModelClass)
            }?.value ?: throw IllegalArgumentException("Unknown ViewModel $modelClass}")

        try {
            @Suppress("UNCHECKED_CAST")
            return viewModelProvider.get() as T
        } catch (ex: RuntimeException) {
            Timber.e(ex)
            throw ex
        }
    }
}