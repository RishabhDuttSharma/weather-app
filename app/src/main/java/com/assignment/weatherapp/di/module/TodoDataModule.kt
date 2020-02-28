package com.assignment.weatherapp.di.module

import com.assignment.weatherapp.data.source.IWeatherRepository
import com.assignment.weatherapp.data.source.WeatherRepository
import com.assignment.weatherapp.data.source.remote.WeatherRemoteDataSource
import com.assignment.weatherapp.data.source.remote.WeatherApi
import com.nagarro.assignment.di.module.ApiModule
import dagger.Module
import dagger.Provides

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
@Module(includes = [ApiModule::class])
object TodoDataModule {

    @Provides
    fun provideTodoRemoteDataSource(api: WeatherApi): WeatherRemoteDataSource =
        WeatherRemoteDataSource(api)

    @Provides
    fun provideTodoDataRepository(remoteDataSource: WeatherRemoteDataSource): IWeatherRepository =
        WeatherRepository(remoteDataSource)
}