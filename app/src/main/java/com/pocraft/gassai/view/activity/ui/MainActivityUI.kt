package com.pocraft.gassai.view.activity.ui

import android.graphics.Color
import android.view.Gravity
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.pocraft.gassai.R
import com.pocraft.gassai.util.bottomNavigationView
import com.pocraft.gassai.view.activity.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.coordinatorLayout

class MainActivityUI: AnkoComponent<MainActivity> {
    lateinit var bottomNavigation: BottomNavigationView

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        coordinatorLayout {
            constraintLayout {
                frameLayout {
                    id = R.id.container
                }.lparams(width = matchParent, height = matchParent) {

                }
            }.lparams(width = matchParent, height = matchParent)

            bottomNavigation = bottomNavigationView {
                id = R.id.main_bottom_nav
                inflateMenu(R.menu.navigation)
                backgroundColorResource = R.color.navbarBG
                setOnNavigationItemSelectedListener(owner)
                labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
                itemIconTintList = resources.getColorStateList(R.color.nav_btn_color, null)
                itemTextColor = resources.getColorStateList(R.color.nav_btn_color, null)
            }.lparams(width = matchParent, height = dip(64)) {
                gravity = Gravity.BOTTOM
                behavior = HideBottomViewOnScrollBehavior<BottomNavigationView>()
            }
        }
    }
}