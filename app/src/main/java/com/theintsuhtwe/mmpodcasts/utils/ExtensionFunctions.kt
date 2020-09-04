package com.theintsuhtwe.mmpodcasts.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.theintsuhtwe.mmpodcasts.R
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.StringBuilder

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




