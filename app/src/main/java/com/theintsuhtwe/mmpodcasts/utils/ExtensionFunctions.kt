package com.theintsuhtwe.mmpodcasts.utils

import android.app.Activity
import android.content.Context
import android.text.Html
import android.text.Spanned
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
    min = totalSecond % 3600
    min = min / 60



    var time = ""
    if(hour>0){
        time = "$hour hr :"
    }
    if(min>0){
        time += " $min min"
    }
    return time


}


fun fromHtmlToString(text : String) : Spanned {

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
        return Html.fromHtml(text)
    } else {
        return  Html.fromHtml(text)
    }
}




