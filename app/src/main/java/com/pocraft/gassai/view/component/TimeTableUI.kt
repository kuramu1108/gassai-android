package com.pocraft.gassai.view.component

import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*

class TimeTableUI: AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        relativeLayout {

            lparams(width = matchParent, height = wrapContent) {
                margin = dip(8)
            }
        }
    }
}