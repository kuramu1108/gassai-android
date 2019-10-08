package com.pocraft.gassai.view.component

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class TimeTablePageUI: AnkoComponent<ViewGroup> {
    lateinit var recyclerView: RecyclerView

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        relativeLayout {
            recyclerView = recyclerView {
                id = R.id.timetable_recyclerview
                layoutManager = LinearLayoutManager(owner.context)
            }.lparams(width = matchParent, height = matchParent) {
            }
            lparams(width = matchParent, height = matchParent)
        }
    }
}