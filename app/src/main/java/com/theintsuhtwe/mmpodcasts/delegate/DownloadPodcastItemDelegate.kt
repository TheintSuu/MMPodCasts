package com.theintsuhtwe.mmpodcasts.delegate

import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO

interface DownloadPodcastItemDelegate {

    fun onTapPodCastItem(value : DownloadVO)
}