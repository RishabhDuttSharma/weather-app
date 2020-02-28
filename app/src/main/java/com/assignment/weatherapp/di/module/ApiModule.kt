package com.nagarro.assignment.di.module

import com.assignment.weatherapp.data.source.remote.WeatherApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
@Module(includes = [NetworkModule::class])
object ApiModule {

    @Provides
    fun provideWeatherApi(retrofit: Retrofit) = retrofit.createApi<WeatherApi>()

    private inline fun <reified T> Retrofit.createApi() = create(T::class.java)
}