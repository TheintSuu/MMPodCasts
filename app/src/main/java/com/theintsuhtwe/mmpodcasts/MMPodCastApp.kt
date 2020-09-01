package com.theintsuhtwe.mmpodcasts

import android.app.Application
import com.theintsuhtwe.mmpodcasts.data.model.GenresModelImpl
import com.theintsuhtwe.mmpodcasts.data.model.PodCastModelImpl

class  MMPodCastApp : Application() {
    override fun onCreate() {
        super.onCreate()
        PodCastModelImpl.initDatabase(applicationContext)
       GenresModelImpl.initDatabase(applicationContext)

    }

}