package com.theintsuhtwe.mmpodcasts.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.data.vos.PlayListItemVO

interface PodCastModel {
    fun getPodCastFromApiSaveToDB(onSuccess:()->Unit,onError : (String)->Unit)


    fun getAllPodCastList(onError:(String) ->Unit): LiveData<List<PlayListItemVO>>

    fun getRandomPodCast(onError: (String) -> Unit) : LiveData<EpisodeVO>

    fun getRandomPodCastFromApiSaveToDB(onSuccess:()-> Unit,onError : (String)->Unit)
}