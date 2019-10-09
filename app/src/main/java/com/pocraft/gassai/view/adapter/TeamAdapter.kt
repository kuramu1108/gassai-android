package com.pocraft.gassai.view.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.R
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.view.component.TeamUI
import com.pocraft.gassai.viewmodel.TimeTableViewModel
import com.varunest.sparkbutton.SparkButton
import com.varunest.sparkbutton.SparkEventListener
import org.jetbrains.anko.AnkoContext

class TeamAdapter(var list: ArrayList<Team> = arrayListOf(), val vm: TimeTableViewModel): RecyclerView.Adapter<TeamAdapter.TeamHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder =
        TeamHolder(TeamUI().createView(AnkoContext.create(parent.context, parent)))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        val team = list[position]
        holder.teamName.text = team.name
        holder.teamDescription.text = team.description
        holder.favButton.isChecked = team.isFavorite
        holder.favButton.setEventListener(object: SparkEventListener {
            override fun onEvent(button: ImageView?, buttonState: Boolean) {
                team.isFavorite = buttonState
                if (!buttonState) vm.updateTeam(team)
            }

            override fun onEventAnimationEnd(button: ImageView?, buttonState: Boolean) {
                vm.updateTeam(team)
            }

            override fun onEventAnimationStart(button: ImageView?, buttonState: Boolean) {

            }
        })
    }

    fun setData(data: List<Team>) {
        list = data as ArrayList<Team>
        notifyDataSetChanged()
    }

    inner class TeamHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var teamName: TextView = itemView.findViewById(R.id.team_ui_name)
        var teamDescription: TextView = itemView.findViewById(R.id.team_ui_description)
        var favButton: SparkButton = itemView.findViewById(R.id.team_fav_button_spark)
    }
}