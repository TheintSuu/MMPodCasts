package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.mmpodcasts.persistence.typeconverters.PodCastTypeConverters


//@Entity(tableName = "playlist")
//data class PlayListItemVO(
//    @SerializedName("added_at_ms") val added_at_ms: Long,
//    @Embedded
//    @TypeConverters(PodCastTypeConverters::class)
//    @SerializedName("data") val  episode : EpisodeVO,
//    @PrimaryKey
//    @ColumnInfo(name = "play_list_id")
//    @SerializedName("id") val id: Int
//)