package com.theintsuhtwe.mmpodcasts.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeDetailVO

interface PodCastDetail{
    fun getPodCastDetail(podCastId : String, onError: (String) -> Unit) : LiveData<EpisodeDetailVO>

    fun getPodCastDetailFromApiSaveToDB(podCastId: String, onSuccess:(EpisodeDetailVO)-> Unit,onError : (String)->Unit)
}