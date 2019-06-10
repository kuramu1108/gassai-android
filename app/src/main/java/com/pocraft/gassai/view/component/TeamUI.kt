package com.pocraft.gassai.view.component

import android.graphics.Color
import android.view.ViewGroup
import com.pocraft.gassai.R
//import com.pocraft.gassai.util.cardView
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class TeamUI: AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        cardView {
            verticalLayout {
                textView {
                    id = R.id.team_ui_name
                    textColor = Color.BLACK
                    textSize = 18f
                }.lparams(width = matchParent) {
                    padding = dip(16)
                }

                textView {
                    id = R.id.team_ui_description
                }.lparams(width = matchParent) {
                    marginStart = dip(16)
                }


//                setPadding(dip(32), dip(16), dip(16), dip(16))
            }.lparams(width = matchParent, height = matchParent) {
                padding = dip(8)
            }

            radius = dip(6).toFloat()
            elevation = dip(6).toFloat()
            lparams(width = matchParent, height = wrapContent) {
                margin = dip(8)
            }
        }
    }
}