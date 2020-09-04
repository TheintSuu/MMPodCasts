package com.theintsuhtwe.mmpodcasts.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.theintsuhtwe.mmgenress.persistence.daos.GenresDao
import com.theintsuhtwe.mmplaylists.persistence.daos.PlayListDao
import com.theintsuhtwe.mmpodcasts.data.vos.GenresVO
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.data.vos.PlayListItemVO
import com.theintsuhtwe.mmpodcasts.persistence.daos.PodCastDao

@Database(entities = [EpisodeVO::class, GenresVO::class, PlayListItemVO::class], version = 8, exportSchema = false)
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
    abstract fun playlistDao() : PlayListDao
    abstract fun genresDao(): GenresDao

}