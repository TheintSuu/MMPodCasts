package com.theintsuhtwe.mmPodcasts.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.theintsuhtwe.mmpodcasts.data.vos.Podcast

class PodCastTypeConverters {
    @TypeConverter
    fun toString(commentList: List<Podcast>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toList(commentListJsonStr: String): ArrayList<Podcast> {
        val commentListType = object : TypeToken<ArrayList<Podcast>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}