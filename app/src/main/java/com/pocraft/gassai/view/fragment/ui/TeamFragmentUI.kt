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
                adapter = TeamAdapter(owner.vm.teamList)
            }.lparams(width = matchParent, height = matchParent)
            lparams(width = matchParent, height = matchParent)
        }
    }
}