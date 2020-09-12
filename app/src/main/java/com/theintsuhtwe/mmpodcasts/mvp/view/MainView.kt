package com.theintsuhtwe.mmpodcasts.mvp.view

import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.shared.mvp.BaseView

interface MainView : BaseView {
    fun displayRandomPodCast(podCast : EpisodeVO)

    fun displayPodCastsList(podCastsList : List<EpisodeVO>)

    fun navigateToPodCastDetails(podCastId: String)

    fun navigateToPlayAudio(podCastId: String)

    fun navigateToDownloadAudio(episodeVO: EpisodeVO)

    fun updatePlayBackId(episodeId : String)

    fun enableSwipeRefresh()

    fun disableSwipeRefresh()


}