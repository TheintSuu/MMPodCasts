package com.theintsuhtwe.mmpodcasts.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.theintsuhtwe.mmpodcasts.data.vos.LookingFor
import com.theintsuhtwe.mmpodcasts.data.vos.Podcast

class LookinForTypeConverters {
    @TypeConverter
    fun toString(commentList: LookingFor): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toList(commentListJsonStr: String): LookingFor {
        val commentListType = object : TypeToken<LookingFor>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}