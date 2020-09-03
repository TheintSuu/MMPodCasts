package com.theintsuhtwe.mmpodcasts.mvp.view

import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO
import com.theintsuhtwe.shared.mvp.BaseView

interface DetailView : BaseView {
    fun displayAllPodCastDetail(detail : PodCastVO)

    fun playAudio(audio : String)
}