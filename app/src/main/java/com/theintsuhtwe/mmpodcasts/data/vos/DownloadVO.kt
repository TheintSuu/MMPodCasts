package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.mmPodcasts.persistence.typeconverters.PodCastTypeConverters


@Entity(tableName = "download")
@TypeConverters(PodCastTypeConverters::class)
data class DownloadVO(
    @PrimaryKey
    @SerializedName("id")  val id: String,
    @SerializedName("path")  val image: String,
    @Embedded
    @SerializedName("podcast_info")  val  podcastInfo : PodCastVO ?= null
) {

}