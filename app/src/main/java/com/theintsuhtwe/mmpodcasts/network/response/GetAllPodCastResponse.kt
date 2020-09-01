package com.theintsuhtwe.mmpodcasts.network.response

import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO

class GetAllPodCastResponse (
    @SerializedName("type") val type : String = "",
    @SerializedName("items") val data : List<PodCastVO> = arrayListOf()
){
    fun isResponseOk() =  (data != null)
}