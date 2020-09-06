package com.theintsuhtwe.mmpodcasts

import android.app.Application
import com.theintsuhtwe.mmpodcasts.data.model.*

class  MMPodCastApp : Application() {
    override fun onCreate() {
        super.onCreate()
      PodCastModelImpl.initDatabase(applicationContext)
       GenresModelImpl.initDatabase(applicationContext)
        PodCastDetailModelImpl.initDatabase(applicationContext)
        RecommendationModelImpl.initDatabase(applicationContext)
       DownloadModelImpl.initDatabase(applicationContext)


    }

}