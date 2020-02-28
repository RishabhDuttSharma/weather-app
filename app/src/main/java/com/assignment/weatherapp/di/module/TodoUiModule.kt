package com.assignment.weatherapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.weatherapp.ui.weatherinfo.WeatherInfoActivity
import com.assignment.weatherapp.ui.weatherinfo.WeatherInfoFragment
import com.assignment.weatherapp.ui.weatherinfo.WeatherInfoViewModel
import com.assignment.weatherapp.util.viewmodel.DaggerViewModelFactory
import com.nagarro.assignment.util.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
@Module
abstract class TodoUiModule {

    @ContributesAndroidInjector
    abstract fun contributesWeatherInfoActivity(): WeatherInfoActivity

    @ContributesAndroidInjector
    abstract fun contributesWeatherInfoFragment(): WeatherInfoFragment

    @Binds
    abstract fun bindsDaggerViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(WeatherInfoViewModel::class)
    abstract fun bindsTodoListViewModel(viewModel: WeatherInfoViewModel): ViewModel
}