package com.theintsuhtwe.mmpodcasts.network.response

import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO
import com.theintsuhtwe.mmpodcasts.utils.GET_GENRES
import com.theintsuhtwe.mmpodcasts.utils.GET_RANDOM_PODCAST
import com.theintsuhtwe.mmpodcasts.utils.GET_UPNEXT_PODCAST
import com.theintsuhtwe.mmpodcasts.utils.Play_List_ID
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PodCastApi {
        @GET(GET_RANDOM_PODCAST)
        fun getRandomPodCast()
                : Observable<PodCastVO>


        @GET(GET_UPNEXT_PODCAST)
        fun getUpNextPodCastList(@Query(Play_List_ID) id : String)
                : Observable<GetAllPodCastResponse>

        @GET(GET_GENRES)
        fun getAllGenres()
                : Observable<GetAllGenresResponse>

        @GET("episodes/:id")
        fun getPodCastDetailById(@Query(Play_List_ID) id : String)
                : Observable<GetAllPodCastResponse>


}