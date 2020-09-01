package com.theintsuhtwe.mmpodcasts.data.vos

import com.google.gson.annotations.SerializedName

data class Podcast(
    @SerializedName("country")  val country: String,
    @SerializedName("description")  val description: String,
    @SerializedName("earliest_pub_date_ms")  val earliest_pub_date_ms: Long,
    @SerializedName("email")  val email: String,
    @SerializedName("explicit_content")  val explicit_content: Boolean,
    @SerializedName("extra")  val extra: Extra,
    @SerializedName("genre_ids")  val genre_ids: List<Int>,
    @SerializedName("id")  val id: String,
    @SerializedName("image")  val image: String,
    @SerializedName("is_claimed")  val is_claimed: Boolean,
    @SerializedName("itunes_id")  val itunes_id: Int,
    @SerializedName("language")  val language: String,
    @SerializedName("latest_pub_date_ms")  val latest_pub_date_ms: Long,
    @SerializedName("listennotes_url")  val listennotes_url: String,
    @SerializedName("looking_for")  val looking_for: LookingFor,
    @SerializedName("publisher")  val publisher: String,
    @SerializedName("rss")  val rss: String,
    @SerializedName("thumbnail")  val thumbnail: String,
    @SerializedName("title")  val title: String,
    @SerializedName("total_episodes")  val total_episodes: Int,
    @SerializedName("type")  val type: String,
    @SerializedName("website")  val website: String
)