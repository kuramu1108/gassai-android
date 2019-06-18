package com.pocraft.gassai.util

import android.util.TypedValue
import android.view.View
import android.view.ViewManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pocraft.gassai.R
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.custom.ankoView

inline fun <reified T: ViewModel> DaggerAppCompatActivity.lazyViewModel(crossinline viewModelFactory: () -> ViewModelProvider.Factory): Lazy<T> {
    return lazy {
        ViewModelProviders.of(this, viewModelFactory.invoke())[T::class.java]
    }
}

inline fun <reified T: ViewModel> Fragment.lazyViewModel(crossinline viewModelFactory: () -> ViewModelProvider.Factory): Lazy<T> {
    return lazy {
        ViewModelProviders.of(activity!!, viewModelFactory.invoke())[T::class.java]
    }
}

// Anko extensions
inline fun ViewManager.bottomNavigationView(init: BottomNavigationView.() -> Unit = {}) =
        ankoView({BottomNavigationView(it)}, theme = 0, init = init)

fun View.actionBarSize(): Int {
    val tv = TypedValue()
    if (context.theme.resolveAttribute(R.attr.actionBarSize, tv, true)) {
        return  TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
    }
    return 0
}