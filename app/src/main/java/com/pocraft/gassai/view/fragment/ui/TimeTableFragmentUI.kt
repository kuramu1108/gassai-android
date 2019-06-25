package com.pocraft.gassai.view.fragment.ui

import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.R
import com.pocraft.gassai.util.viewPager2
import com.pocraft.gassai.view.fragment.TimeTableFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.design.tabLayout

class TimeTableFragmentUI: AnkoComponent<TimeTableFragment> {
    lateinit var recyclerView: RecyclerView
    override fun createView(ui: AnkoContext<TimeTableFragment>) = with(ui) {
        relativeLayout {
            id = R.id.timeTableFragment
            val tab = tabLayout {
                id = R.id.time_table_tab
            }.lparams(width = matchParent, height = wrapContent)

            viewPager2 {
                id = R.id.time_table_view_pager
            }.lparams(width = matchParent) {
                below(tab)
                alignParentBottom()
            }
//            recyclerView = recyclerView {
//                layoutManager = LinearLayoutManager(owner.context)
//
//
//                adapter = TimeTableAdapter()
//            }.lparams(width = matchParent, height = matchParent)
            lparams(width = matchParent, height = matchParent)
        }
    }
}