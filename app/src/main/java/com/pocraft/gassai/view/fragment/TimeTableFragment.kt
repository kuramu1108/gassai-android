package com.pocraft.gassai.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.pocraft.gassai.util.lazyViewModel
import com.pocraft.gassai.view.adapter.TimeTablePageAdapter
import com.pocraft.gassai.view.fragment.ui.TimeTableFragmentUI
import com.pocraft.gassai.viewmodel.TimeTableViewModel
import dagger.android.support.AndroidSupportInjection
import org.jetbrains.anko.AnkoContext
import javax.inject.Inject

class TimeTableFragment: Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val vm by lazyViewModel<TimeTableViewModel> { viewModelFactory }

    lateinit var ui: TimeTableFragmentUI

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = TimeTableFragmentUI()
        val view = ui.createView(AnkoContext.create(inflater.context, this, false))

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ui.viewPager.adapter = TimeTablePageAdapter(arrayListOf(vm.timeTableList1, vm.timeTableList2))

        ui.tab.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                ui.tab.selectTab(tab)
            }
        })

        val mediator = TabLayoutMediator(ui.tab, ui.viewPager) { tab: TabLayout.Tab, position: Int ->
            tab.text = "position $position"
        }
        mediator.attach()
    }
}