package com.pocraft.gassai.view.fragment.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.R
import com.pocraft.gassai.view.adapter.TimeTableAdapter
import com.pocraft.gassai.view.fragment.TimeTableFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class TimeTableFragmentUI: AnkoComponent<TimeTableFragment> {
    lateinit var recyclerView: RecyclerView
    override fun createView(ui: AnkoContext<TimeTableFragment>) = with(ui) {
        relativeLayout {
            id = R.id.timeTableFragment
            recyclerView = recyclerView {
                layoutManager = LinearLayoutManager(owner.context)


                adapter = TimeTableAdapter()
            }.lparams(width = matchParent, height = matchParent)
            lparams(width = matchParent, height = matchParent)
        }
    }
}