package com.theintsuhtwe.mmpodcasts.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.theintsuhtwe.mmpodcasts.data.model.DownloadModelImpl
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeDetailVO
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.mvp.view.DownloadView
import com.theintsuhtwe.mmpodcasts.utils.getEpisodeDetailVO
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter

class DownloadPresenterImpl:  DownloadPresenter, AbstractBasePresenter<DownloadView>() {


    var mPodCastModel = DownloadModelImpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        requestAllPodCast(lifeCycleOwner)
    }

    override fun onTabAudioPlay(podcastId: String) {

    }

    override fun onTapPodCastItem(value: DownloadVO) {
       mView?.navigateToPodCastDetails(getEpisodeDetailVO(value))
    }

    override fun onTapTryAgain() {
        loadAllPodCast()
    }

    private fun requestAllPodCast(lifeCycleOwner: LifecycleOwner) {


        val downloadList = mPodCastModel.getAllDownloadPodCastList(onError = {

        })

        mView?.displayDownloadPodCastsList(downloadList)


    }

    private fun loadAllPodCast(){
        val downloadList = mPodCastModel.getAllDownloadPodCastList(onError = {

        })

        mView?.displayDownloadPodCastsList(downloadList)
    }


}