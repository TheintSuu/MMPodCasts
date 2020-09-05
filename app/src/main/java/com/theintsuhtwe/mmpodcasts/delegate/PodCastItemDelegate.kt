package com.theintsuhtwe.mmpodcasts.delegate

import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO

interface PodCastItemDelegate {

    fun onTapPodCastItem(value : String)

    fun onTapDownloadItem(episodeVO: EpisodeVO)
}