package com.pocraft.gassai.view.activity.ui

import android.graphics.Color
import android.widget.Button
import android.widget.TextView
import androidx.core.view.marginBottom
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pocraft.gassai.R
import com.pocraft.gassai.util.bottomNavigationView
import com.pocraft.gassai.view.activity.MainActivity
import org.jetbrains.anko.*

class MainActivityUI: AnkoComponent<MainActivity> {
    lateinit var bottomNavigation: BottomNavigationView

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        relativeLayout {
            frameLayout {
                id = R.id.container
            }.lparams(width = matchParent) {
                alignParentTop()
            }

            bottomNavigation = bottomNavigationView {
                id = R.id.main_bottom_nav
                inflateMenu(R.menu.navigation)
                backgroundColor = Color.WHITE
                setOnNavigationItemSelectedListener(owner)
            }.lparams(width = matchParent, height = wrapContent) {
                alignParentBottom()
            }
        }
    }
}