package com.pocraft.gassai.util

import android.view.ViewManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.custom.ankoView

inline fun <reified T: ViewModel> DaggerAppCompatActivity.lazyViewModel(crossinline viewModelFactory: () -> ViewModelProvider.Factory): Lazy<T> {
    return lazy {
        ViewModelProviders.of(this, viewModelFactory.invoke())[T::class.java]
    }
}

// Anko extensions
inline fun ViewManager.bottomNavigationView(init: BottomNavigationView.() -> Unit = {}) =
        ankoView({BottomNavigationView(it)}, theme = 0, init = init)