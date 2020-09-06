package com.theStringsuhtwe.mmpodcasts.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class GenresTypeConverters {
    @TypeConverter
    fun toString(commentList: List<String>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): List<String> {
        val commentListType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}