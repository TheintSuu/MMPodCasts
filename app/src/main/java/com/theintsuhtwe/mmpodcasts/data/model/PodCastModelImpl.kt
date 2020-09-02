package com.theintsuhtwe.mmpodcasts.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO
import com.theintsuhtwe.mmpodcasts.utils.Play_List_ID_KEY
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PodCastModelImpl : PodCastModel, BaseModel() {


    @SuppressLint("CheckResult")
    override fun getPodCastFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mPodCastApi
            .getUpNextPodCastList(Play_List_ID_KEY)
            .map { it.data.toMutableList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                it.forEach {
                    mPodCastDB.podCastDao().insertpodcast(it.data)
                }
            },{
                onError(it.localizedMessage ?: it.localizedMessage)
            })

    }

    override fun getAllPodCastList(onError: (String) -> Unit): LiveData<List<PodCastVO>> {
        return mPodCastDB.podCastDao().getAllpodcast()
    }

    override fun getRandomPodCast(onError: (String) -> Unit): LiveData<PodCastVO> {
        return mPodCastDB.podCastDao().getPodCastRandom()
    }

    @SuppressLint("CheckResult")
    override fun getRandomPodCastFromApiSaveToDB(onSuccess: () -> PodCastVO, onError: (String) -> Unit):  {
        mPodCastApi
            .getRandomPodCast()
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                //onSuccess(it)
                mPodCastDB.podCastDao().insertpodcast(it)
            },{
                onError(it.localizedMessage ?: it.localizedMessage)
            })
    }

    private fun onSuccess(it: PodCastVO?) : PodCastVO? {

    }


}