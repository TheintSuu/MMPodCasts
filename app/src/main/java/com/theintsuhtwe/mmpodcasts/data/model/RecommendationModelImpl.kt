package com.theintsuhtwe.mmpodcasts.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.data.vos.PlayListItemVO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object RecommendationModelImpl : RecommendationModel, BaseModel(){


    @SuppressLint("CheckResult")
    override fun getPodCastFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {
//        mPodCastApi
//            .getUpNextPodCastList(Play_List_ID_KEY)
//            .map { it.data.toMutableList() }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe ({
//
//                    mPodCastDB.playlistDao().insertAllplaylist(it)
//
//            },{
//                onError(it.localizedMessage ?: it.localizedMessage)
//            })


        mPodCastTestApi.getAllRecommendation()
            .map { it.data.toMutableList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                //onSuccess(it)
                //   onSuccess(it)
               mPodCastDB.podCastDao().insertAllpodcast(it)
            },{
                onError(it.localizedMessage ?: it.localizedMessage)
            })



    }

    override fun getAllPodCastList(onError: (String) -> Unit): LiveData<List<EpisodeVO>> {
        return mPodCastDB.podCastDao().getAllpodcast()
    }
}