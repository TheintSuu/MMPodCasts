package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



@Entity(tableName = "download")

data class DownloadVO(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")  var id: Int = 0,
    @SerializedName("path")  val path: String,
    @SerializedName("audio")  val audio: String,
    @SerializedName("audio_length")  val audio_length: Int,
    @SerializedName("description")  val description: String,
    @SerializedName("episode_id")  val episodeId: String,
    @SerializedName("image")  val image: String,
    @SerializedName("listennotes_url")  val listennotes_url: String,
    @SerializedName("pub_date_ms")  val pub_date_ms: Long,
    @SerializedName("thumbnail")  val thumbnail: String,
    @SerializedName("title")  val title: String,
    @SerializedName("podcast")  val podcast:PodcastVO

)