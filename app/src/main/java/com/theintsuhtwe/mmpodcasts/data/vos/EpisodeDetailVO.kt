package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "detail")
data class EpisodeDetailVO(
    @SerializedName("audio")  val audio: String,
    @SerializedName("audio_length_sec")  val audio_length_sec: Int,
    @SerializedName("audio_length")  val audio_length: Int,
    @SerializedName("description")  val description: String,
    @SerializedName("explicit_content")  val explicit_content: Boolean,
    @PrimaryKey
    @SerializedName("id")  val id: String,
    @SerializedName("image")  val image: String,
    //@SerializedName("link")  val link: String,
    @SerializedName("podcast") val podcast : PodcastVO,
    @SerializedName("listennotes_edit_url")  val listennotes_edit_url: String,
    @SerializedName("listennotes_url")  val listennotes_url: String,
    @SerializedName("maybe_audio_in")  val maybe_audio_in : Boolean,
    @SerializedName("pub_date_ms")  val pub_date_ms: Long,
    @SerializedName("thumbnail")  val thumbnail: String,
    @SerializedName("title")  val title: String
)