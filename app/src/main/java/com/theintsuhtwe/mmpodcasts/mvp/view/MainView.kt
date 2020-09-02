package com.theintsuhtwe.mmpodcasts.mvp.view

import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO
import com.theintsuhtwe.shared.mvp.BaseView

interface MainView : BaseView {
    fun displayRandomPodCast(podCast : PodCastVO)

    fun displayPodCastsList(podCastsList : List<PodCastVO>)

    fun navigateToPodCastDetails(podCastId: String)

    fun navigateToPlayAudio(podCastId: String)


}