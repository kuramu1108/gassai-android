package com.pocraft.gassai.view.activity.ui

import android.graphics.Color
import android.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pocraft.gassai.R
import com.pocraft.gassai.util.bottomNavigationView
import com.pocraft.gassai.view.activity.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.themedAppBarLayout

class MainActivityUI: AnkoComponent<MainActivity> {
    lateinit var bottomNavigation: BottomNavigationView
    lateinit var toolbar: Toolbar

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        relativeLayout {
            val appBar = themedAppBarLayout(R.style.AppTheme_ActionBar) {
                //                backgroundResource = R.color.colorPrimary
                id = R.id.app_bar_layout
                toolbar = toolbar {
                    id = R.id.toolbar
                    title = ""
                }.lparams(width = matchParent, height = dip(48))
            }.lparams(width = matchParent)

            bottomNavigation = bottomNavigationView {
                id = R.id.main_bottom_nav
                inflateMenu(R.menu.navigation)
                backgroundColor = Color.WHITE
                setOnNavigationItemSelectedListener(owner)
            }.lparams(width = matchParent, height = dip(64)) {
                alignParentBottom()
            }

            frameLayout {
                id = R.id.container
            }.lparams(width = matchParent) {
                below(appBar)
                above(bottomNavigation)
            }
        }
    }
}