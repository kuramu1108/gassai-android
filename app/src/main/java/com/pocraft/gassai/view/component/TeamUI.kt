package com.pocraft.gassai.view.component

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.pocraft.gassai.R
import com.pocraft.gassai.util.sparkButton
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class TeamUI: AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        cardView {
            relativeLayout {
                val teamImage = imageView (R.drawable.test){
                    id = R.id.team_image
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }.lparams(width = dip(120), height = dip(75)) {
                }

                val teamDetail = verticalLayout {
                    textView {
                        id = R.id.team_ui_name
                        textColor = Color.BLACK
                        textSize = 18f
                    }.lparams(width = matchParent) {
                        marginStart = dip(16)
                    }

                    textView {
                        id = R.id.team_ui_description
                    }.lparams(width = matchParent) {
                        marginStart = dip(16)
                    }
                }.lparams(height = matchParent) {
                    rightOf(teamImage)
                }

                sparkButton {
                    id = R.id.team_fav_button_spark
                }.lparams(height = dip(30), width = dip(30)) {
                    centerVertically()
                    alignParentRight()
                    marginEnd = dip(8)
                }

                clipChildren = false
                clipToPadding = false
            }.lparams(width = matchParent, height = matchParent) {
            }

            radius = dip(6).toFloat()
            elevation = dip(6).toFloat()
            lparams(width = matchParent, height = wrapContent) {
                margin = dip(8)
            }
        }
    }
}