package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genres")
data class GenresVO(
    @SerializedName("id")  val id: Int,
    @SerializedName("name")  val name: String,
    @SerializedName("parent_id")  val parent_id: Int
)