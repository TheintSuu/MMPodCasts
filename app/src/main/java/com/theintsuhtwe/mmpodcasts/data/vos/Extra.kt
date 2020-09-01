package com.theintsuhtwe.mmpodcasts.data.vos

import com.google.gson.annotations.SerializedName

data class Extra(
    @SerializedName("facebook_handle")  val facebook_handle: String,
    @SerializedName("google_url")  val google_url: String,
    @SerializedName("instagram_handle")  val instagram_handle: String,
    @SerializedName("linkedin_url")  val linkedin_url: String,
    @SerializedName("patreon_handle")  val patreon_handle: String,
    @SerializedName("spotify_url")  val spotify_url: String,
    @SerializedName("twitter_handle")  val twitter_handle: String,
    @SerializedName("url1")  val url1: String,
    @SerializedName("url2")  val url2: String,
    @SerializedName("url3")  val url3: String,
    @SerializedName("youtube_url")  val youtube_url: String
)