package com.pocraft.gassai.view.activity.ui

import android.graphics.Color
import android.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pocraft.gassai.R
import com.pocraft.gassai.util.bottomNavigationView
import com.pocraft.gassai.view.activity.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.appBarLayout

class MainActivityUI: AnkoComponent<MainActivity> {
    lateinit var bottomNavigation: BottomNavigationView
    lateinit var toolbar: Toolbar

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        relativeLayout {
            appBarLayout {
                toolbar = toolbar {
                    id = R.id.toolbar
                    backgroundColor = R.color.colorPrimary
                    title = "test"
                    elevation = 4f
                }.lparams(width = matchParent, height = dip(64))
            }.lparams(width = matchParent)

            frameLayout {
                id = R.id.container
            }.lparams(width = matchParent) {
                topMargin = dip(64)
                bottomMargin = dip(64)
            }

            bottomNavigation = bottomNavigationView {
                id = R.id.main_bottom_nav
                inflateMenu(R.menu.navigation)
                backgroundColor = Color.WHITE
                setOnNavigationItemSelectedListener(owner)
            }.lparams(width = matchParent, height = dip(64)) {
                alignParentBottom()
            }
        }
    }
}