package com.pocraft.gassai.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pocraft.gassai.util.lazyViewModel
import com.pocraft.gassai.view.fragment.ui.ReminderFragmentUI
import com.pocraft.gassai.viewmodel.TimeTableViewModel
import dagger.android.support.AndroidSupportInjection
import org.jetbrains.anko.AnkoContext
import javax.inject.Inject

class ReminderFragment: Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val vm by lazyViewModel<TimeTableViewModel> { viewModelFactory }

    private lateinit var ui: ReminderFragmentUI

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = ReminderFragmentUI()
        return ui.createView(AnkoContext.create(inflater.context, this, false))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.repoSize.observe(viewLifecycleOwner, Observer {
            ui.textView.text = it.toString()
        })
    }
}