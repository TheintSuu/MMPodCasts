package com.theintsuhtwe.mmpodcasts.network.response

import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.data.vos.GenresVO

class GetAllRecommendation(
    @SerializedName("recommendations") val data : ArrayList<EpisodeVO> = arrayListOf()
) {

}