package com.pocraft.gassai.view.adapter

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.databinding.ListItemPostFeedFragmentBinding
import com.pocraft.gassai.model.Post

class PostAdapter: ListAdapter<Post, PostAdapter.ViewHolder>(PostDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(itemCount - position - 1)
        holder.bind(item)
    }

    class ViewHolder(val binding: ListItemPostFeedFragmentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {
            binding.post = item
            binding.expandButton.setOnClickListener {
                if (binding.textView.maxLines > 3) collapseTextView(binding.textView)
                else expandTextView(binding.textView)
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemPostFeedFragmentBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun expandTextView(view: TextView) {
            val animation = ObjectAnimator.ofInt(view, "maxLines", view.lineCount)
            animation.apply {
                duration = 400
                start()
            }
        }

        fun collapseTextView(view: TextView) {
            val animation = ObjectAnimator.ofInt(view, "maxLines", 3)
            animation.apply {
                duration = 400
                start()
            }
        }
    }
}

class PostDiffCallback: DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem.id == newItem.id

}