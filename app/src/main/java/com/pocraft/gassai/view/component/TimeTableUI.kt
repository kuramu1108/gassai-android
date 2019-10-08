package com.pocraft.gassai.view.component

import android.view.View
import android.view.ViewGroup
import com.pocraft.gassai.R
import org.jetbrains.anko.*

class TimeTableUI: AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        relativeLayout {
            val time = textView {
                id = R.id.timetable_time
            }.lparams(width = wrapContent, height = wrapContent) {
                marginStart = dip(8)
            }

            val team = textView {
                id = R.id.timetable_team
            }.lparams(width = matchParent, height = wrapContent) {
                marginEnd = dip(16)
            }

            lparams(width = matchParent, height = wrapContent) {
                margin = dip(8)
            }
        }
    }
}