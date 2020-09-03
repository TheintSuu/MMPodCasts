package com.theintsuhtwe.mmpodcasts.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.mmpodcasts.mvp.view.DownloadView
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

class DownloadPresenterImpl : DownloadPresenter, AbstractBasePresenter<DownloadView>() {
    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        TODO("Not yet implemented")
    }

    override fun onTabAudioPlay(podcastId: String) {
        TODO("Not yet implemented")
    }

    override fun onTapPodCastItem(value: String) {
        TODO("Not yet implemented")
    }


}