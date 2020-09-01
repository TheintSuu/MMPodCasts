package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "playEpisode")
data class PlayEpisodeListVO(
    @SerializedName("added_at_ms")  val added_at_ms: Long,
    @SerializedName("data")  val data : PodCastVO,
    @SerializedName("id")  val id: Int,
    @SerializedName("notes")  val notes: String,
    @SerializedName("type")  val type: String

)