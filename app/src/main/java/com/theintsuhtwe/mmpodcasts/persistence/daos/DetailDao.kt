package com.theintsuhtwe.mmdetails.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeDetailVO

@Dao
interface DetailDao {

    @Query("SELECT * FROM detail")
    fun getAlldetail(): LiveData<List<EpisodeDetailVO>>

    @Query("SELECT * FROM detail WHERE id = :noteId")
    fun getdetailById(noteId: String) : LiveData<EpisodeDetailVO>

    @Query("DELETE FROM detail")
    fun deleteAll()

    @Delete
    fun deletedetail(note: EpisodeDetailVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertdetail(noteVO: EpisodeDetailVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlldetail(detail: List<EpisodeDetailVO>)

    @Query("SELECT * FROM detail ORDER BY id Desc LIMIT 1")
    fun getdetailRandom(): LiveData<EpisodeDetailVO>
}