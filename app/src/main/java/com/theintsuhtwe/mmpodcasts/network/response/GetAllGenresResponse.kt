package com.theintsuhtwe.mmpodcasts.network.response

import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.mmpodcasts.data.vos.GenresVO

class GetAllGenresResponse(
    @SerializedName("genres") val data : ArrayList<GenresVO> = arrayListOf()
) {

}