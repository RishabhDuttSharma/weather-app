package com.assignment.weatherapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/17/2020
 */
@SuppressLint("Registered")
abstract class BaseActivity<VDB : ViewDataBinding> constructor(
    @LayoutRes private val layoutResId: Int
) : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set content view using data-binding
        DataBindingUtil.setContentView<VDB>(this, layoutResId).run {
            // continue initialization
            initComponents(savedInstanceState, this)
        }
    }

    // initialize other components required after onCreate
    abstract fun initComponents(savedInstanceState: Bundle?, binding: VDB)
}