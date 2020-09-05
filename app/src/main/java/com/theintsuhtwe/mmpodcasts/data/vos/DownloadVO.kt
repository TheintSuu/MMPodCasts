package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



@Entity(tableName = "download")

data class DownloadVO(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")  val id: Int = 1,
    @SerializedName("path")  val path: String,
    @SerializedName("podcast_info")  var  podcastInfo : EpisodeVO?= null
)