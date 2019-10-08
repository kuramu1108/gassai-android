package com.pocraft.gassai.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pocraft.gassai.util.lazyViewModel
import com.pocraft.gassai.view.fragment.ui.TeamFragmentUI
import com.pocraft.gassai.viewmodel.TimeTableViewModel
import dagger.android.support.AndroidSupportInjection
import org.jetbrains.anko.AnkoContext
import javax.inject.Inject

class TeamFragment: Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val vm by lazyViewModel<TimeTableViewModel> { viewModelFactory }
    lateinit var ui: TeamFragmentUI

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = TeamFragmentUI()
        val view = ui.createView(AnkoContext.create(inflater.context, this, false))
        return view
    }
}