package com.pocraft.gassai.view.fragment.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.R
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.view.adapter.TeamAdapter
import com.pocraft.gassai.view.fragment.TeamFragment
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textView

class TeamFragmentUI: AnkoComponent<TeamFragment> {
    lateinit var recyclerView: RecyclerView
    override fun createView(ui: AnkoContext<TeamFragment>) = with(ui) {
        relativeLayout {
            id = R.id.teamFragment
            textView {
                text = "Team"
            }
            recyclerView = recyclerView {
                layoutManager = LinearLayoutManager(owner.context)
                val list = arrayListOf<Team>(
                    Team(0, "abc", "JAP", 5, "longtexxt"),
                    Team(1, "s", "JAP", 5, "longtexxt"),
                    Team(2, "abcsd", "JAP", 5, "longtexxt"),
                    Team(3, "abcddd", "JAP", 5, "l"),
                    Team(4, "ccc", "JAP", 5, "longtexxtasdfa")
                )
                adapter = TeamAdapter(list)
            }
        }
    }
}