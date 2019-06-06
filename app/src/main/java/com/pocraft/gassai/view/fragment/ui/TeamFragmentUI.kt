package com.pocraft.gassai.view.fragment.ui

import android.view.View
import com.pocraft.gassai.R
import com.pocraft.gassai.view.fragment.TeamFragment
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textView

class TeamFragmentUI: AnkoComponent<TeamFragment> {
    override fun createView(ui: AnkoContext<TeamFragment>) = with(ui) {
        relativeLayout {
            id = R.id.teamFragment
            textView {
                text = "Team"
            }
        }
    }
}