package com.assignment.weatherapp.di.module

import android.app.Application
import com.assignment.weatherapp.WeatherApp
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
@Module
class AppModule(private val application: WeatherApp) {

    @ApplicationContext
    @Provides
    fun provideApplication(): Application = application
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext