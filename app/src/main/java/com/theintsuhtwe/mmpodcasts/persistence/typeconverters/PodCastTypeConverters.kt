package com.theintsuhtwe.mmpodcasts.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.data.vos.PodcastVO

class PodCastTypeConverters {
    @TypeConverter
    fun toString(commentList:EpisodeVO): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toList(commentListJsonStr: String): EpisodeVO {
        val commentListType = object : TypeToken<EpisodeVO>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}