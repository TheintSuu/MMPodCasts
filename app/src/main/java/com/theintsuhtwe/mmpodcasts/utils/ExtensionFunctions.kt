package com.theintsuhtwe.mmpodcasts.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun loadImage(itemView : View, url : String, toImageView : ImageView){
    Glide.with(itemView.context)
        .load(url)
        .into(toImageView)
}