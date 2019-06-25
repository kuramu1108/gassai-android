package com.pocraft.gassai.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.pocraft.gassai.R
import com.pocraft.gassai.view.adapter.TimeTablePageAdapter
import com.pocraft.gassai.view.fragment.ui.TimeTableFragmentUI
import org.jetbrains.anko.AnkoContext

class TimeTableFragment: Fragment() {
    lateinit var ui: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = TimeTableFragmentUI().createView(AnkoContext.create(inflater.context, this, false))
        return ui
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager2 = ui.findViewById<ViewPager2>(R.id.time_table_view_pager)
        viewPager2.adapter = TimeTablePageAdapter()
    }
}