package com.theintsuhtwe.mmplaylists.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.theintsuhtwe.mmpodcasts.data.vos.PlayListItemVO


@Dao
interface PlayListDao {

    @Query("SELECT * FROM playlist")
    fun getAllplaylist(): LiveData<List<PlayListItemVO>>

    @Query("SELECT * FROM playlist WHERE play_list_id = :noteId")
    fun getplaylistById(noteId: Int) : LiveData<PlayListItemVO>

    @Query("DELETE FROM playlist")
    fun deleteAll()

    @Delete
    fun deleteplaylist(note: PlayListItemVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertplaylist(noteVO: PlayListItemVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllplaylist(playlist: List<PlayListItemVO>)

    @Query("SELECT * FROM playlist ORDER BY id Desc LIMIT 1")
    fun getplaylistRandom(): LiveData<PlayListItemVO>
}