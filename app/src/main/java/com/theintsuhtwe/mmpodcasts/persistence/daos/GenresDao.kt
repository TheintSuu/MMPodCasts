package com.theintsuhtwe.mmgenress.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.theintsuhtwe.mmpodcasts.data.vos.GenresVO


@Dao
interface GenresDao {

    @Query("SELECT * FROM genres")
    fun getAllGenres(): LiveData<List<GenresVO>>

    @Query("SELECT * FROM genres WHERE id = :noteId")
    fun getgenresById(noteId: Int): LiveData<GenresVO>

    @Query("DELETE FROM genres")
    fun deleteAll()

    @Delete
    fun deleteGenres(note: GenresVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenres(noteVO: GenresVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllGenres(genres: List<GenresVO>)

    @Query("SELECT * FROM genres ORDER BY id Desc LIMIT 1")
    fun getGenresRandom(): LiveData<GenresVO>

}
