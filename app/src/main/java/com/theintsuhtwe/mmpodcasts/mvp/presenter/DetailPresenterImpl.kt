package com.theintsuhtwe.mmpodcasts.mvp.presenter

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.theintsuhtwe.mmpodcasts.data.model.PodCastDetailModelImpl
import com.theintsuhtwe.mmpodcasts.mvp.view.DetailView
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {

    private var mPodCastDetail = PodCastDetailModelImpl

    override fun onUiReady(podCastId: String, lifecycleOwner: LifecycleOwner) {
        getAllPodCastDetail(podCastId, lifecycleOwner)
    }

    override fun onTabAudioPlay(audioUri: String) {
        mView?.playAudio(audioUri)
    }

    override fun onTapPodCastItem(value: String) {

    }

    override fun onTapDownloadItem(fileName: String, uri: String) {

    }

    private fun getAllPodCastDetail(podCastId : String, lifecycleOwner: LifecycleOwner){

        mPodCastDetail.getPodCastDetail(podCastId){

        }.observe(lifecycleOwner, Observer {
            it?.let {
                mView?.displayAllPodCastDetail(it)
            }

        })
        mPodCastDetail.getPodCastDetailFromApiSaveToDB(podCastId,
            onSuccess = {},
            onError = {
                Log.d("Error","hello")
            })
    }
}