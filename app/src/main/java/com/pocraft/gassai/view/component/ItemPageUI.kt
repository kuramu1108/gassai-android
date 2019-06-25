package com.pocraft.gassai.view.component

import android.view.ViewGroup
import com.pocraft.gassai.R
import org.jetbrains.anko.*

class ItemPageUI: AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        relativeLayout {
            textView {
                id = R.id.textView_test
            }.lparams(width = wrapContent) {
                centerInParent()
            }
            lparams(width = matchParent, height = matchParent)
        }
    }
}