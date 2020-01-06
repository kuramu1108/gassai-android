package com.pocraft.gassai.view.fragment.ui

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.pocraft.gassai.R
import com.pocraft.gassai.util.viewPager2
import com.pocraft.gassai.view.fragment.TimeTableFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.design.tabLayout

class TimeTableFragmentUI: AnkoComponent<TimeTableFragment> {
    lateinit var recyclerView: RecyclerView
    lateinit var tab: TabLayout
    lateinit var viewPager: ViewPager2

    override fun createView(ui: AnkoContext<TimeTableFragment>) = with(ui) {
        relativeLayout {
            backgroundColorResource = R.color.colorBackGround
            id = R.id.timeTableFragment
            tab = tabLayout {
                id = R.id.time_table_tab
                backgroundColorResource = R.color.colorPrimary
                setSelectedTabIndicatorColor(Color.BLACK)
                tabMode = TabLayout.MODE_SCROLLABLE
            }.lparams(width = matchParent, height = wrapContent)

            viewPager = viewPager2 {
                id = R.id.time_table_view_pager

            }.lparams(width = matchParent) {
                below(tab)
                alignParentBottom()
            }
            lparams(width = matchParent, height = matchParent)
        }
    }
}