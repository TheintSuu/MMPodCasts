package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.mmpodcasts.persistence.typeconverters.ExtraTypeConverters
import com.theintsuhtwe.mmpodcasts.persistence.typeconverters.GenresTypeConverters
import com.theintsuhtwe.mmpodcasts.persistence.typeconverters.LookinForTypeConverters


data class PodcastVO(
    //@Embedded
   // @TypeConverters(GenresTypeConverters::class)
   // @SerializedName("genre_ids")  val genre_ids: List<Int>,
    @PrimaryKey
    @ColumnInfo(name = "podcast_id")
    @SerializedName("id")  val id: String,
    @ColumnInfo(name = "podcast-description")
    @SerializedName("description")  val description: String,
    //@SerializedName("listennotes_url")  val listennotes_url: String,
    @ColumnInfo(name ="podcast_title")
    @SerializedName("title")  val title: String
//    @SerializedName("country")  val country: String,

//    @SerializedName("earliest_pub_date_ms")  val earliest_pub_date_ms: Long,
//    @SerializedName("email")  val email: String,
//    @SerializedName("explicit_content")  val explicit_content: Boolean,
//    @SerializedName("extra")  val extra: Extra,
//    @SerializedName("image")  val image: String,
//    @SerializedName("is_claimed")  val is_claimed: Boolean,
//    @SerializedName("itunes_id")  val itunes_id: Int,
//    @SerializedName("language")  val language: String,
//    @SerializedName("latest_pub_date_ms")  val latest_pub_date_ms: Long,
    //@SerializedName("looking_for")  val looking_for: LookingFor,
//    @SerializedName("publisher")  val publisher: String,
//    @SerializedName("rss")  val rss: String,
//    @SerializedName("thumbnail")  val thumbnail: String,
//    @SerializedName("total_episodes")  val total_episodes: Int,
//    @SerializedName("type")  val type: String,
//    @SerializedName("website")  val website: String


)