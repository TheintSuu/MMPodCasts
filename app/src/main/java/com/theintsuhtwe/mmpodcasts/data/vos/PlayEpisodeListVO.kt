package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "playlist")
data class PlayEpisodeListVO(
    @SerializedName("added_at_ms")  val added_at_ms: Long,
    @SerializedName("data")  val data : PodCastVO,
    @PrimaryKey
    @SerializedName("id")  val id: Int,
    @SerializedName("notes")  val notes: String,
    @SerializedName("type")  val type: String

)