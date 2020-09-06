package com.theintsuhtwe.mmpodcasts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO
import com.theintsuhtwe.mmpodcasts.delegate.DownloadPodcastItemDelegate
import com.theintsuhtwe.mmpodcasts.views.viewholders.DownloadViewHolder
import com.theintsuhtwe.shared.Adapter.BaseAdapter
import com.theintsuhtwe.shared.Viewholders.BaseViewHolder

class DownloadPodCastAdapter (delegate : DownloadPodcastItemDelegate) : BaseAdapter<BaseViewHolder<DownloadVO>, DownloadVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownloadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_download_podcast, parent, false)
        return  DownloadViewHolder(view, mDelegate)

    }
}