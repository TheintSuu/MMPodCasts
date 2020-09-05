package com.theintsuhtwe.mmpodcasts.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO
import com.theintsuhtwe.mmpodcasts.data.vos.PlayListItemVO

interface DownloadModel {

    fun getDownloadPodCastById(id : Int) : DownloadVO


    fun getAllDownloadPodCastList(onError:(String) ->Unit): List<DownloadVO>


    fun insertDownloadPodCast(episode : DownloadVO)
}