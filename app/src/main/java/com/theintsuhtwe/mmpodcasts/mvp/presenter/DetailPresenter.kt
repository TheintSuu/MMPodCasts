package com.theintsuhtwe.mmpodcasts.mvp.presenter

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.mvp.view.DetailView
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

interface DetailPresenter : PodCastItemDelegate, BasePresenter<DetailView> {
    fun onUiReady(podCastId : String, lifecycleOwner: LifecycleOwner)

    fun onTabAudioPlay(audioUri : String)
}