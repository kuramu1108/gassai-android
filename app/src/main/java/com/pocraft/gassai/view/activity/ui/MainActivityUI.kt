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
    lateinit var textView: TextView
    lateinit var resultText: TextView
    lateinit var fetchButton: Button
    lateinit var bottomNavigation: BottomNavigationView

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        relativeLayout {
            textView = textView {
                id = R.id.text_view
                text = "test"
            }

            fetchButton = button {
                id = R.id.fetch_button
                text = "fetch"
            }.lparams(width = wrapContent, height = wrapContent) {
                bottomOf(textView)
            }

            resultText = textView {
                id = R.id.result_text_view
                text = ""
            }.lparams(width = wrapContent, height = wrapContent) {
                bottomOf(fetchButton)
            }

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