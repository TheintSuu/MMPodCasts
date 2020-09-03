package com.theintsuhtwe.mmpodcasts.utils

import android.app.Activity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun loadImage(itemView : Activity, url : String, toImageView : ImageView) {
    Glide.with(itemView)
        .load(url)
        .centerCrop()
        .into(toImageView)
}

fun audioPlayTime(totalSecond : Int): String{

    var hour = 0
    var  min = 0

    hour = totalSecond / 3600
     min = hour % 60

    var time = ""
    if(hour>0){
        time = "$hour hr"
    }
    if(min>0){
        time += " : $min min"
    }
    return time


}