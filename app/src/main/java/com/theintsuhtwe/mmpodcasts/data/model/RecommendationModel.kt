package com.theintsuhtwe.mmpodcasts.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.data.vos.PlayListItemVO

interface RecommendationModel {

    fun getPodCastFromApiSaveToDB(onSuccess:()->Unit,onError : (String)->Unit)


    fun getAllPodCastList(onError:(String) ->Unit): LiveData<List<EpisodeVO>>
}