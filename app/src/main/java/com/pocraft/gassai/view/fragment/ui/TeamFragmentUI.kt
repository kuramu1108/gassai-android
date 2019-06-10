package com.pocraft.gassai.view.fragment.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.R
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.view.adapter.TeamAdapter
import com.pocraft.gassai.view.fragment.TeamFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class TeamFragmentUI: AnkoComponent<TeamFragment> {
    lateinit var recyclerView: RecyclerView
    override fun createView(ui: AnkoContext<TeamFragment>) = with(ui) {
        relativeLayout {
            id = R.id.teamFragment
            recyclerView = recyclerView {
                layoutManager = LinearLayoutManager(owner.context)
                val list = arrayListOf<Team>(
                    Team(0, "abc", "JAP", 5, "longtexxt"),
                    Team(1, "s", "JAP", 5, "longtexxt"),
                    Team(2, "abcsd", "JAP", 5, "longtexxt"),
                    Team(3, "abcddd", "JAP", 5, "l"),
                    Team(4, "cc_c", "JAP", 5, "longtexsfdgsdfgsdfgxtasdfa"),
                    Team(5, "abcddd", "JAP", 5, "l"),
                    Team(6, "abcddd", "JAP", 5, "l"),
                    Team(7, "abcddd", "JAP", 5, "l"),
                    Team(8, "abcddd", "JAP", 5, "l"),
                    Team(9, "abcddd", "JAP", 5, "l")
                )
                adapter = TeamAdapter(list)
            }.lparams(width = matchParent, height = matchParent)
            lparams(width = matchParent, height = matchParent)
        }
    }
}