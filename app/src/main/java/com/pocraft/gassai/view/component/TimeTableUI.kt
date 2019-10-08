package com.pocraft.gassai.view.component

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import com.pocraft.gassai.R
import com.pocraft.gassai.util.reminderSparkButton
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class TimeTableUI: AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        cardView {
            relativeLayout {
                val time = textView {
                    id = R.id.timetable_time
                }.lparams(width = wrapContent, height = wrapContent) {
                    horizontalMargin = dip(16)
                    alignParentLeft()
                    centerVertically()
                }

                val divider = view {
                    id = R.id.divider
                    setBackgroundColor(Color.MAGENTA)
                }.lparams(width = dip(3), height = matchParent) {
                    rightOf(time)
                    verticalMargin = dip(8)
                }

                val team = textView {
                    id = R.id.timetable_team
                }.lparams(width = wrapContent, height = wrapContent) {
                    marginStart = dip(16)
                    rightOf(divider)
                    centerVertically()
                }

                reminderSparkButton {
                    id = R.id.timetable_reminder_button
                }.lparams(width = dip(30), height = dip(30)) {
                    centerVertically()
                    alignParentRight()
                    marginEnd = dip(16)
                }
                clipChildren = false
                clipToPadding = false
            }.lparams(width = matchParent, height = dip(75)) {
            }

            radius = dip(3).toFloat()
            elevation = dip(6).toFloat()
            lparams(width = matchParent, height = wrapContent) {
                margin = dip(8)
            }
        }
    }
}