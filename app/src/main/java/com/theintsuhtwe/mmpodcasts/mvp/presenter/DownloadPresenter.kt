package com.theintsuhtwe.mmpodcasts.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.mvp.view.DownloadView
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

interface DownloadPresenter :  PodCastItemDelegate,
    BasePresenter<DownloadView> {

    fun onUiReady(lifeCycleOwner: LifecycleOwner)


    fun onTabAudioPlay( podcastId : String)

}