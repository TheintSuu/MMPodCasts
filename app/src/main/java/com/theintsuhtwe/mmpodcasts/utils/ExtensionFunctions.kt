package com.theintsuhtwe.mmpodcasts.utils

import android.app.Activity
import android.content.Intent
import android.os.Environment
import android.text.Html
import android.text.Spanned
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeDetailVO
import java.io.IOException
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.reflect.KClass

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

fun Intent.putExtraJson(name: String, src: Any) {
    putExtra(name, IntentUtil.gson.toJson(src))
}


fun <T> Intent.getJsonExtra(name: String, `class`: Class<T>): T? {
    val stringExtra = getStringExtra(name)
    if (stringExtra != null) {
        return IntentUtil.gson.fromJson<T>(stringExtra, `class`)
    }
    return null
}

fun getEpisodeDetailVO(value : DownloadVO) : EpisodeDetailVO{
   return EpisodeDetailVO(
        audio =  value.path,
        audio_length = value.audio_length,
        image = value.image,
        id = value.episodeId,
        title = value.title,
        thumbnail = value.thumbnail,
        description = value.description,
        pub_date_ms = value.pub_date_ms,
        podcast = value.podcast,
        maybe_audio_in = false,
        listennotes_url = "",
        listennotes_edit_url = "",
        explicit_content = false,
        audio_length_sec = 0
    )

}


object IntentUtil {
    @Suppress("SpellCheckingInspection")
    val gson: Gson = GsonBuilder().create()
}



