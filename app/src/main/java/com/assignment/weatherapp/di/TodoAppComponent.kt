package com.assignment.weatherapp.di

import com.assignment.weatherapp.WeatherApp
import com.assignment.weatherapp.di.module.TodoDataModule
import com.assignment.weatherapp.di.module.TodoUiModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        TodoUiModule::class,
        TodoDataModule::class
    ]
)
interface TodoAppComponent : AndroidInjector<WeatherApp>