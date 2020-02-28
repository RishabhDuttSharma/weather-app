package com.assignment.weatherapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.assignment.weatherapp.util.ext.getViewModel
import com.assignment.weatherapp.util.viewmodel.DaggerViewModelFactory
import dagger.Lazy
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */
abstract class BaseFragment<VDB : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : DaggerFragment() {

    @Inject
    lateinit var viewModelFactoryProvider: Lazy<DaggerViewModelFactory>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<VDB>(inflater, layoutResId, container, false).apply {
        // continue initializing other components
        initComponents(savedInstanceState, this)
    }.root

    abstract fun initComponents(savedInstanceState: Bundle?, binding: VDB)

    protected inline fun <reified T : ViewModel> getViewModel() =
        getViewModel<T>(viewModelFactoryProvider.get())

    private inline fun <reified T : ViewModel> getActivityViewModel() =
        activity?.getViewModel<T>(viewModelFactoryProvider.get())
}