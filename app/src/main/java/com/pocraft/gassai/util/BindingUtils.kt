package com.pocraft.gassai.util

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.pocraft.gassai.R

@BindingAdapter("postImageUrl")
fun ImageView.setPostImageUrl(url: String?) {
    url?.let {
        Glide.with(context)
            .load(it)
            .error(R.drawable.test)
            .into(this)
    } ?: run {
        Glide.with(context)
            .load(ColorDrawable(Color.GRAY))
            .into(this)
    }
}