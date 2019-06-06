package com.pocraft.gassai.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.lifecycle.ViewModelProvider
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

    private lateinit var ui: MainActivityUI

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.navigation_home -> {
                ui.textView.setText(R.string.title_home)
                true
            }
            R.id.navigation_dashboard -> {
                ui.textView.setText(R.string.title_dashboard)
                true
            }
            R.id.navigation_notifications -> {
                ui.textView.setText(R.string.title_notifications)
                true
            }
            else -> false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        ui = MainActivityUI()
        ui.setContentView(this)

        vm.repoSize.observe(this, Observer {
            ui.resultText.text = it.toString()
        })

        ui.fetchButton.setOnClickListener {
            ui.fetchButton.text = vm.getName()
//            ui.resultText.text = vm.getRepo().toString()
            vm.getRepo()
        }
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
