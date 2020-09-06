package com.theintsuhtwe.mmdownloads.persistence.daos


import androidx.room.*
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO

@Dao
interface DownloadDao {
    @Query("SELECT * FROM download")
    fun getAlldownload(): List<DownloadVO>

    @Query("SELECT * FROM download WHERE id = :noteId")
    fun getdownloadById(noteId: Int) : DownloadVO

    @Query("DELETE FROM download")
    fun deleteAll()

    @Delete
    fun deletedownload(note: DownloadVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertdownload(noteVO: DownloadVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlldownload(download: List<DownloadVO>)


}