package com.theintsuhtwe.mmpodcasts.mvp.view

import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.shared.mvp.BaseView

interface DetailView : BaseView {
    fun displayAllPodCastDetail(detail : EpisodeVO)

    fun playAudio(audio : String)
}