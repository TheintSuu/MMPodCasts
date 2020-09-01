package com.theintsuhtwe.mmpodcasts.data.vos

import com.google.gson.annotations.SerializedName

data class Playlists(
    @SerializedName("description")  val description: String,
    @SerializedName("episode_count")  val episode_count: Int,
    @SerializedName("id")  val id: String,
    @SerializedName("image")  val image: String,
    @SerializedName("listennotes_url")  val listennotes_url: String,
    @SerializedName("name")  val name: String,
    @SerializedName("podcast_count")  val podcast_count: Int,
    @SerializedName("thumbnail")  val thumbnail: String,
    @SerializedName("visibility")  val visibility: String
)