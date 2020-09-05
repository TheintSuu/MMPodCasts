package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.mmpodcasts.persistence.typeconverters.PodCastTypeConverters


@Entity(tableName = "download")
@TypeConverters(PodCastTypeConverters::class)
data class DownloadVO(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")  val id: Int = 1,
    @SerializedName("path")  val path: String,
    @SerializedName("podcast_info")  val  podcastInfo : EpisodeVO?= null
)