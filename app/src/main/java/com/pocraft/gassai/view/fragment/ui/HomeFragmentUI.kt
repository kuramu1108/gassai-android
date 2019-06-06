package com.pocraft.gassai.view.fragment.ui

import android.view.View
import com.pocraft.gassai.R
import com.pocraft.gassai.view.fragment.HomeFragment
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textView

class HomeFragmentUI: AnkoComponent<HomeFragment> {
    override fun createView(ui: AnkoContext<HomeFragment>) = with(ui) {
        relativeLayout {
            id = R.id.homeFragment
            textView {
                text = "home"
            }
        }
    }
}