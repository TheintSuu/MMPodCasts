package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.mmpodcasts.persistence.typeconverters.PodCastTypeConverters


data class DataVO(
    @SerializedName("title") val title: String,
    @Embedded
    @TypeConverters(PodCastTypeConverters::class)
    @SerializedName("podcast") val podcast: EpisodeVO,
    @PrimaryKey
    @ColumnInfo(name = "episode_id")
    @SerializedName("id") val episodeId: String
)