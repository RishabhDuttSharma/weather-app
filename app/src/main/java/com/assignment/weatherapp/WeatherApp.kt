package com.assignment.weatherapp

import com.assignment.weatherapp.di.DaggerWeatherAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/13/2020
 */
class WeatherApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerWeatherAppComponent.builder().build()

    override fun onCreate() {
        super.onCreate()

        // initialize timber for debug build
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}