package com.theintsuhtwe.mmpodcasts.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.mvp.view.MainView
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

interface MainPresenter : PodCastItemDelegate,
    BasePresenter<MainView> {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)

    fun onRandomUIReady(lifeCycleOwner: LifecycleOwner)

    fun onTabAudioPlay( podcastId : String)

}
