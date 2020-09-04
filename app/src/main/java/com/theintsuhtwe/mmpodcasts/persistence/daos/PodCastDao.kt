package com.theintsuhtwe.mmpodcasts.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO

@Dao
interface PodCastDao {

    @Query("SELECT * FROM podcast")
    fun getAllpodcast(): LiveData<List<EpisodeVO>>

    @Query("SELECT * FROM podcast WHERE id = :noteId")
    fun getpodcastById(noteId: String) : LiveData<EpisodeVO>

    @Query("DELETE FROM podcast")
    fun deleteAll()

    @Delete
    fun deletepodcast(note: EpisodeVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertpodcast(noteVO: EpisodeVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllpodcast(podcast: List<EpisodeVO>)

    @Query("SELECT * FROM podcast ORDER BY id Desc LIMIT 1")
    fun getPodCastRandom(): LiveData<EpisodeVO>
}