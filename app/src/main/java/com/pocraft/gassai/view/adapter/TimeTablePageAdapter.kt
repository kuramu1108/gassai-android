package com.pocraft.gassai.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.R
import com.pocraft.gassai.view.component.ItemPageUI
import org.jetbrains.anko.AnkoContext

class TimeTablePageAdapter: RecyclerView.Adapter<TimeTablePageAdapter.PagerVH>() {
    private val test = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(ItemPageUI().createView(AnkoContext.create(parent.context, parent)))

    override fun getItemCount() = test.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) =
        holder.run {
            text.text = "item $position"
//            itemView.container.setBackgroundResource(test[position])
        }

    inner class PagerVH(itemView: View): RecyclerView.ViewHolder(itemView) {
        var text: TextView = itemView.findViewById(R.id.textView_test)
    }
}