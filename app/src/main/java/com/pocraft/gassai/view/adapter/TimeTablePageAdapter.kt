package com.pocraft.gassai.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.R
import com.pocraft.gassai.model.TimeTable
import com.pocraft.gassai.view.component.TimeTablePageUI
import org.jetbrains.anko.AnkoContext

class TimeTablePageAdapter(var list: ArrayList<ArrayList<TimeTable>> = arrayListOf()): RecyclerView.Adapter<TimeTablePageAdapter.PagerVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(TimeTablePageUI().createView(AnkoContext.create(parent.context, parent)))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) =
        holder.run {
            recyclerView.adapter = TimeTableAdapter(list[position])
        }

    inner class PagerVH(itemView: View): RecyclerView.ViewHolder(itemView) {
//        var text: TextView = itemView.findViewById(R.id.textView_test)
        var recyclerView: RecyclerView = itemView.findViewById(R.id.timetable_recyclerview)
    }
}