package com.pocraft.gassai.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior
import com.pocraft.gassai.R
import com.pocraft.gassai.util.lazyViewModel
import com.pocraft.gassai.view.activity.ui.MainActivityUI
import com.pocraft.gassai.viewmodel.TimeTableViewModel
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val vm: TimeTableViewModel by lazyViewModel { viewModelFactory }

    private val navHost by lazy { NavHostFragment.create(R.navigation.nav_graph) }

    private lateinit var ui: MainActivityUI

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        ui = MainActivityUI()
        ui.setContentView(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, navHost)
            .setPrimaryNavigationFragment(navHost)
            .commit()
    }

    override fun onStart() {
        super.onStart()
        val navController = navHost.findNavController()
        ui.bottomNavigation.setupWithNavController(navController)
        ui.bottomNavigation.setOnNavigationItemReselectedListener {
            
        }
//        navController.addOnDestinationChangedListener { controller, destination, arguments ->
//
//        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (ui.bottomNavigation.translationY != 0f) {
            val layoutParams = ui.bottomNavigation.layoutParams as CoordinatorLayout.LayoutParams
            val behavior = layoutParams.behavior as HideBottomViewOnScrollBehavior

            behavior.slideUp(ui.bottomNavigation)
        }
    }
}
