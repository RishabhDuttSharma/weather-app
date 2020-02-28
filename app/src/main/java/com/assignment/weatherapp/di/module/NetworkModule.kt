package com.nagarro.assignment.di.module

import com.assignment.weatherapp.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
@Module
object NetworkModule {

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, converterFactory: Converter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(BuildConfig.TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .readTimeout(BuildConfig.TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .writeTimeout(BuildConfig.TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .build()

    @Provides
    fun provideMoshiConverterFactory(): Converter.Factory = MoshiConverterFactory.create()

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
}