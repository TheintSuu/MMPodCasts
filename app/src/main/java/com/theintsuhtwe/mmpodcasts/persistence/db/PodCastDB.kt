package com.theintsuhtwe.mmpodcasts.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.theStringsuhtwe.mmpodcasts.persistence.typeconverters.GenresTypeConverters
import com.theintsuhtwe.mmdetails.persistence.daos.DetailDao
import com.theintsuhtwe.mmdownloads.persistence.daos.DownloadDao
import com.theintsuhtwe.mmgenress.persistence.daos.GenresDao
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeDetailVO
import com.theintsuhtwe.mmpodcasts.data.vos.GenresVO
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.persistence.daos.PodCastDao
import com.theintsuhtwe.mmpodcasts.persistence.typeconverters.PodCastTypeConverters

@Database(entities = [EpisodeVO::class, GenresVO::class,  DownloadVO::class, EpisodeDetailVO::class], version = 17, exportSchema = false)
@TypeConverters(GenresTypeConverters::class, PodCastTypeConverters::class)
abstract class PodCastDB : RoomDatabase() {
    companion object {
        val DB_NAME = "PADC_X_PodCast.DB"
        var dbInstance: PodCastDB? = null

        fun getDBInstance(context: Context): PodCastDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, PodCastDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun podCastDao(): PodCastDao
//    abstract fun playlistDao() : PlayListDao
    abstract fun genresDao(): GenresDao
    abstract fun detailDao(): DetailDao
    abstract fun downloadDao(): DownloadDao

}