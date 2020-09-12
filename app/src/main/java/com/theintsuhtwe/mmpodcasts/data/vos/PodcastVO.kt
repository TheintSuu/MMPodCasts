package com.theintsuhtwe.mmpodcasts.data.vos

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class PodcastVO(
    @SerializedName("genres")  val genre_ids: List<String>,
    @PrimaryKey
    @ColumnInfo(name = "podcast_id")
    @SerializedName("id")  val podCastId: String,
    @ColumnInfo(name = "podcast-description")
    @SerializedName("description")  val description: String,

    @ColumnInfo(name ="podcast_title")
    @SerializedName("title")  val title: String
//    @SerializedName("country")  val country: String,
    //@SerializedName("listennotes_url")  val listennotes_url: String,
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


){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PodcastVO

        if (genre_ids != other.genre_ids) return false
        if (podCastId != other.podCastId) return false
        if (description != other.description) return false
        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        var result = genre_ids.hashCode()
        result = 31 * result + podCastId.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + title.hashCode()
        return result
    }
}
