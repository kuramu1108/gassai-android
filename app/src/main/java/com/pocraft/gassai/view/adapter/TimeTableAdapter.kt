package com.pocraft.gassai.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.R
import com.pocraft.gassai.model.TimeTable
import com.pocraft.gassai.view.component.TimeTableUI
import com.varunest.sparkbutton.SparkButton
import com.varunest.sparkbutton.SparkEventListener
import org.jetbrains.anko.AnkoContext

class TimeTableAdapter(var list: ArrayList<TimeTable> = arrayListOf()): RecyclerView.Adapter<TimeTableAdapter.TimeTableViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeTableViewHolder =
        TimeTableViewHolder(TimeTableUI().createView(AnkoContext.create(parent.context, parent)))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TimeTableViewHolder, position: Int) {
        val timeTable = list[position]
        holder.run {
            textTeam.text = timeTable.team?.name
            textTime.text = timeTable.time.toString()
            reminderButton.setEventListener(object : SparkEventListener {
                override fun onEventAnimationEnd(button: ImageView?, buttonState: Boolean) {

                }

                override fun onEvent(button: ImageView?, buttonState: Boolean) {

                }

                override fun onEventAnimationStart(button: ImageView?, buttonState: Boolean) {
                }
            })
        }
    }

    inner class TimeTableViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var textTime = itemView.findViewById<TextView>(R.id.timetable_time)
        var textTeam = itemView.findViewById<TextView>(R.id.timetable_team)
        var reminderButton: SparkButton = itemView.findViewById(R.id.timetable_reminder_button)
    }
}