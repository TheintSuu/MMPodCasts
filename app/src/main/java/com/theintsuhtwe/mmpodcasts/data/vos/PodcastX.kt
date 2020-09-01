package com.theintsuhtwe.mmpodcasts.data.vos

import com.google.gson.annotations.SerializedName

data class PodcastX(
    @SerializedName("id")  val id: String,
    @SerializedName("image")  val image: String,
    @SerializedName("listennotes_url")  val listennotes_url: String,
    @SerializedName("publisher")  val publisher: String,
    @SerializedName("thumbnail")  val thumbnail: String,
    @SerializedName("title")  val title: String
)