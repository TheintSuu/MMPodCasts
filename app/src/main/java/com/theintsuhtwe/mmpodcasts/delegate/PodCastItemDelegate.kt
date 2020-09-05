package com.theintsuhtwe.mmpodcasts.delegate

interface PodCastItemDelegate {

    fun onTapPodCastItem(value : String)

    fun onTapDownloadItem(fileName : String, uri : String)
}