package com.theintsuhtwe.mmpodcasts.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PodCastDetailModelImpl : PodCastDetail, BaseModel() {


    override fun getPodCastDetail(
        podCastId: String,
        onError: (String) -> Unit
    ): LiveData<PodCastVO> {
        return mPodCastDB.podCastDao().getpodcastById(podCastId)

    }

    @SuppressLint("CheckResult")
    override fun getPodCastDetailFromApiSaveToDB(
        podCastId: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mPodCastApi
            .getPodCastDetailById(podCastId)
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                PodCastDetailModelImpl.mPodCastDB.podCastDao().insertpodcast(it)
            }, {
                onError(it.localizedMessage ?: it.localizedMessage)
            })
    }


}