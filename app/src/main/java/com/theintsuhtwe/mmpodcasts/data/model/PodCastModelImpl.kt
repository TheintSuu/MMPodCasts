package com.theintsuhtwe.mmpodcasts.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PodCastModelImpl : PodCastModel, BaseModel() {


//    @SuppressLint("CheckResult")
//    override fun getPodCastFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {
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
//
//
////        mPodCastTestApi.getAllRecommendation("deecd6ee486f4f47abe61998efc2c0c2")
////            .map { it.data.toMutableList() }
////            .subscribeOn(Schedulers.io())
////            .observeOn(AndroidSchedulers.mainThread())
////            .subscribe ({
////                //onSuccess(it)
////                //   onSuccess(it)
////                mPodCastDB.podCastDao().insertAllpodcast(it)
////            },{
////                onError(it.localizedMessage ?: it.localizedMessage)
////            })
//
//
//
//    }
//
//    override fun getAllPodCastList(onError: (String) -> Unit): LiveData<List<PlayListItemVO>> {
//        return mPodCastDB.playlistDao().getAllplaylist()
//    }

    override fun getRandomPodCast(onError: (String) -> Unit): LiveData<EpisodeVO> {
        return mPodCastDB.podCastDao().getPodCastRandom()
    }

    @SuppressLint("CheckResult")
    override fun getRandomPodCastFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mPodCastTestApi
            .getRandomPodCast()
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                //onSuccess(it)
             //   onSuccess(it)
              //  mPodCastDB.podCastDao().insertpodcast(it)
            },{
                onError(it.localizedMessage ?: it.localizedMessage)
            })
    }




}