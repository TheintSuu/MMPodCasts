package com.theintsuhtwe.mmpodcasts.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO

interface PodCastDetail{
    fun getPodCastDetail(podCastId : String, onError: (String) -> Unit) : LiveData<PodCastVO>

    fun getPodCastDetailFromApiSaveToDB(podCastId: String, onSuccess:()-> Unit,onError : (String)->Unit)
}