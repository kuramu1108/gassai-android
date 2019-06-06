package com.pocraft.gassai.view.fragment.ui

import android.view.View
import com.pocraft.gassai.R
import com.pocraft.gassai.view.fragment.TimeTableFragment
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textView

class TimeTableFragmentUI: AnkoComponent<TimeTableFragment> {
    override fun createView(ui: AnkoContext<TimeTableFragment>) = with(ui) {
        relativeLayout {
            id = R.id.timeTableFragment
            textView {
                text = "Timetable"
            }
        }
    }
}