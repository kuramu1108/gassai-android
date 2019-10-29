package com.pocraft.gassai.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.util.lazyViewModel
import com.pocraft.gassai.view.adapter.TeamAdapter
import com.pocraft.gassai.view.fragment.ui.TeamFragmentUI
import com.pocraft.gassai.viewmodel.TimeTableViewModel
import dagger.android.support.AndroidSupportInjection
import org.jetbrains.anko.AnkoContext
import javax.inject.Inject

class TeamFragment: Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val vm by lazyViewModel<TimeTableViewModel> { viewModelFactory }

    lateinit var adapter: TeamAdapter
    lateinit var ui: TeamFragmentUI

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = TeamFragmentUI()

        val view = ui.createView(AnkoContext.create(inflater.context, this, false))

        adapter = ui.recyclerView.adapter as TeamAdapter
        adapter.setData(vm.teams())
//        vm.teams().observe(this, Observer<List<Team>> { t ->
//            adapter.setData(t)
//            Log.v("ttt", "tets")
//        })
        return view
    }
}