package com.theintsuhtwe.mmpodcasts.mvp.view

import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.shared.mvp.BaseView

interface DownloadView : BaseView {

    fun displayDownloadPodCastsList(podCastsList : List<DownloadVO>)

    fun navigateToPodCastDetails(episodeId: String)




}