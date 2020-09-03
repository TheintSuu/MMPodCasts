package com.theintsuhtwe.mmpodcasts.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO

@Dao
interface PodCastDao {

    @Query("SELECT * FROM podcast")
    fun getAllpodcast(): LiveData<List<PodCastVO>>

    @Query("SELECT * FROM podcast WHERE id = :noteId")
    fun getpodcastById(noteId: String) : LiveData<PodCastVO>

    @Query("DELETE FROM podcast")
    fun deleteAll()

    @Delete
    fun deletepodcast(note: PodCastVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertpodcast(noteVO: PodCastVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllpodcast(podcast: List<PodCastVO>)

    @Query("SELECT * FROM podcast ORDER BY id Desc LIMIT 1")
    fun getPodCastRandom(): LiveData<PodCastVO>
}