package com.nagarro.assignment.util.viewmodel

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)