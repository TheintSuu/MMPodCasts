package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.mmpodcasts.persistence.typeconverters.PodCastTypeConverters


@Entity(tableName = "download")

data class DownloadVO(
    @PrimaryKey
    @SerializedName("id")  val id: String,
    @SerializedName("path")  val image: String,
    @Embedded
    @TypeConverters(PodCastTypeConverters::class)
    @SerializedName("podcast_info")  val  podcastInfo : EpisodeVO?= null
) {

}