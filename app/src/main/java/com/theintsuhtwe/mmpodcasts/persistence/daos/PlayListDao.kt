package com.theintsuhtwe.mmplaylists.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.theintsuhtwe.mmpodcasts.data.vos.PlayEpisodeListVO


@Dao
interface PlayListDao {

    @Query("SELECT * FROM playlist")
    fun getAllplaylist(): LiveData<List<PlayEpisodeListVO>>

    @Query("SELECT * FROM playlist WHERE id = :noteId")
    fun getplaylistById(noteId: Int) : LiveData<PlayEpisodeListVO>

    @Query("DELETE FROM playlist")
    fun deleteAll()

    @Delete
    fun deleteplaylist(note: PlayEpisodeListVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertplaylist(noteVO: PlayEpisodeListVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllplaylist(playlist: List<PlayEpisodeListVO>)

    @Query("SELECT * FROM playlist ORDER BY id Desc LIMIT 1")
    fun getplaylistRandom(): LiveData<PlayEpisodeListVO>
}