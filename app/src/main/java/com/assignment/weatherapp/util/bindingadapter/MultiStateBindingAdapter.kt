package com.assignment.weatherapp.util.bindingadapter

import androidx.databinding.BindingAdapter
import com.kennyc.view.MultiStateView

/**
 *
 * Developer: Rishabh Dutt Sharma
 * Dated: 2/28/2020
 */

@BindingAdapter("viewState")
fun bindMultiViewState(view: MultiStateView, viewState: MultiStateView.ViewState?) {
    viewState?.let { view.viewState = it }
}