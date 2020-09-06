package com.theintsuhtwe.mmpodcasts.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.theintsuhtwe.mmpodcasts.data.vos.PodcastVO


class PodCastTypeConverters {
    @TypeConverter
    fun toString(commentList:PodcastVO): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toList(commentListJsonStr: String): PodcastVO {
        val commentListType = object : TypeToken<PodcastVO>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}