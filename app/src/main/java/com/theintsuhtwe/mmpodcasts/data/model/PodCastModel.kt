package com.theintsuhtwe.mmpodcasts.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO

interface PodCastModel {
    fun getPodCastFromApiSaveToDB(onSuccess:()->Unit,onError : (String)->Unit)


    fun getAllPodCastList(onError:(String) ->Unit): LiveData<List<PodCastVO>>

    fun getRandomPodCast(onError: (String) -> Unit) : LiveData<PodCastVO>

    fun getRandomPodCastFromApiSaveToDB(onSuccess:()->Unit,onError : (String)->Unit)
}