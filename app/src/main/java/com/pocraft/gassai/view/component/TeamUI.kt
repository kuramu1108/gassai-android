package com.pocraft.gassai.view.component

import android.view.ViewGroup
import com.pocraft.gassai.R
import org.jetbrains.anko.*

class TeamUI: AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            textView {
                id = R.id.team_ui_name
            }.lparams(width = matchParent) {
//                marginStart = dip(16)
            }

            textView {
                id = R.id.team_ui_description
            }.lparams(width = matchParent) {
                marginStart = dip(16)
            }

            lparams(width = matchParent, height = wrapContent)
            setPadding(dip(32), dip(16), dip(16), dip(16))
        }
    }
}