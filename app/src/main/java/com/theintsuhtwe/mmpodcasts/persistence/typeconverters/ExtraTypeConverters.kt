package com.theintsuhtwe.mmpodcasts.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.theintsuhtwe.mmpodcasts.data.vos.Extra
import com.theintsuhtwe.mmpodcasts.data.vos.Podcast

class ExtraTypeConverters {
    @TypeConverter
    fun toString(commentList: Extra): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toList(commentListJsonStr: String): Extra {
        val commentListType = object : TypeToken<Extra>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}