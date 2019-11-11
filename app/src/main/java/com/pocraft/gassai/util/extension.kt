package com.pocraft.gassai.util

import android.util.TypedValue
import android.view.View
import android.view.ViewManager
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pocraft.gassai.R
import com.pocraft.gassai.view.layout.NestedCoordinatorLayout
import com.varunest.sparkbutton.SparkButton
import com.varunest.sparkbutton.SparkButtonBuilder
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
inline fun ViewManager.toolbarv7(init: Toolbar.() -> Unit): Toolbar {
    return ankoView({Toolbar(it)}, theme = 0, init = init)
}

inline fun ViewManager.nestedCoordinatorLayout(init: NestedCoordinatorLayout.() -> Unit = {}) =
        ankoView({NestedCoordinatorLayout(it)}, theme = R.attr.coordinatorLayoutStyle, init = init)

inline fun ViewManager.bottomNavigationView(init: BottomNavigationView.() -> Unit = {}) =
        ankoView({BottomNavigationView(it)}, theme = 0, init = init)

inline fun ViewManager.viewPager2(init: ViewPager2.() -> Unit = {}) =
        ankoView({ViewPager2(it)}, theme = 0, init = init)

inline fun ViewManager.favSparkButton(init: SparkButton.() -> Unit = {}): SparkButton =
        ankoView({
            SparkButtonBuilder(it)
                .setActiveImage(R.drawable.ic_favorite_red_24dp)
                .setInactiveImage(R.drawable.ic_favorite_border_black_24dp)
                .setImageSizeDp(30)
                .setPrimaryColor(it.getColor(R.color.sparkPrimary))
                .setSecondaryColor(it.getColor(R.color.sparkPrimaryDark))
                .build()
        }, theme = 0, init = init)

inline fun ViewManager.reminderSparkButton(init: SparkButton.() -> Unit = {}): SparkButton =
    ankoView({
        SparkButtonBuilder(it)
            .setActiveImage(R.drawable.ic_notifications_active_black_24dp)
            .setInactiveImage(R.drawable.ic_notifications_none_black_24dp)
            .setImageSizeDp(30)
            .setPrimaryColor(it.getColor(R.color.reminderSparkPrimary))
            .setSecondaryColor(it.getColor(R.color.reminderSparkPrimaryDark))
            .build()
    }, theme = 0, init = init)

fun View.actionBarSize(): Int {
    val tv = TypedValue()
    if (context.theme.resolveAttribute(R.attr.actionBarSize, tv, true)) {
        return  TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
    }
    return 0
}