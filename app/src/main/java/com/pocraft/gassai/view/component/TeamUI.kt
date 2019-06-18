package com.pocraft.gassai.view.component

import android.graphics.Color
import android.view.ViewGroup
import android.widget.ImageView
import com.pocraft.gassai.R
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

                imageButton(R.drawable.ic_favorite_border_black_24dp) {
                    id = R.id.team_fav_button
                    backgroundColor = Color.TRANSPARENT
                }.lparams(width = dip(30), height = dip(30)) {
                    centerVertically()
                    alignParentRight()
                    marginEnd = dip(8)
                }
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