package com.theintsuhtwe.mmpodcasts.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class GenresTypeConverters {
    @TypeConverter
    fun toString(commentList: List<Int>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): List<Int> {
        val commentListType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}