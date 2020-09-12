package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Genres(
    @PrimaryKey
    @SerializedName("id")  val id: Int,
    @SerializedName("name")  val name: String,
    @SerializedName("parent_id")  val parent_id: Int

)


