package com.pocraft.gassai.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity

inline fun <reified T: ViewModel> DaggerAppCompatActivity.lazyViewModel(crossinline viewModelFactory: () -> ViewModelProvider.Factory): Lazy<T> {
    return lazy {
        ViewModelProviders.of(this, viewModelFactory.invoke())[T::class.java]
    }
}