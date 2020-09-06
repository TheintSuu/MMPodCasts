package com.theintsuhtwe.mmpodcasts.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeDetailVO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PodCastDetailModelImpl : PodCastDetail, BaseModel() {


    override fun getPodCastDetail(
        podCastId: String,
        onError: (String) -> Unit
    ): LiveData<EpisodeDetailVO> {
        return mPodCastDB.detailDao().getdetailById(podCastId)

    }

    @SuppressLint("CheckResult")
    override fun getPodCastDetailFromApiSaveToDB(
        podCastId: String,
        onSuccess: (EpisodeDetailVO) -> Unit,
        onError: (String) -> Unit
    ) {
        mPodCastTestApi
            .getPodCastDetailById(podCastId)
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

               mPodCastDB.detailDao().insertdetail(it)
                onSuccess(it)
            }, {
                onError(it.localizedMessage ?: it.localizedMessage)
            })
    }


}