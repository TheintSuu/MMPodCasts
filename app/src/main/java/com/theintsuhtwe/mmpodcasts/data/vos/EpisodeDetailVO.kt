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
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EpisodeDetailVO

        if (audio != other.audio) return false
        if (audio_length_sec != other.audio_length_sec) return false
        if (audio_length != other.audio_length) return false
        if (description != other.description) return false
        if (explicit_content != other.explicit_content) return false
        if (id != other.id) return false
        if (image != other.image) return false
        if (podcast != other.podcast) return false
        if (listennotes_edit_url != other.listennotes_edit_url) return false
        if (listennotes_url != other.listennotes_url) return false
        if (maybe_audio_in != other.maybe_audio_in) return false
        if (pub_date_ms != other.pub_date_ms) return false
        if (thumbnail != other.thumbnail) return false
        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        var result = audio.hashCode()
        result = 31 * result + audio_length_sec
        result = 31 * result + audio_length
        result = 31 * result + description.hashCode()
        result = 31 * result + explicit_content.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + image.hashCode()
        result = 31 * result + podcast.hashCode()
        result = 31 * result + listennotes_edit_url.hashCode()
        result = 31 * result + listennotes_url.hashCode()
        result = 31 * result + maybe_audio_in.hashCode()
        result = 31 * result + pub_date_ms.hashCode()
        result = 31 * result + thumbnail.hashCode()
        result = 31 * result + title.hashCode()
        return result
    }
}