package com.theintsuhtwe.mmpodcasts.data.model


import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO


interface DownloadModel {

    fun getDownloadPodCastById(id : Int) : DownloadVO


    fun getAllDownloadPodCastList(onError:(String) ->Unit): List<DownloadVO>


    fun insertDownloadPodCast(episode : DownloadVO)
}