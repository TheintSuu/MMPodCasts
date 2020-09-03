package com.theintsuhtwe.mmdownloads.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO

interface DownloadDao {
    @Query("SELECT * FROM download")
    fun getAlldownload(): LiveData<List<DownloadVO>>

    @Query("SELECT * FROM download WHERE id = :noteId")
    fun getdownloadById(noteId: String) : LiveData<DownloadVO>

    @Query("DELETE FROM download")
    fun deleteAll()

    @Delete
    fun deletedownload(note: DownloadVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertdownload(noteVO: DownloadVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlldownload(download: List<DownloadVO>)

    @Query("SELECT * FROM download ORDER BY id Desc LIMIT 1")
    fun getdownloadRandom(): LiveData<DownloadVO>
}