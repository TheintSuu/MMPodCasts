package com.theintsuhtwe.mmpodcasts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.views.viewholders.CategoryViewHolder
import com.theintsuhtwe.mmpodcasts.views.viewholders.DownloadViewHolder
import com.theintsuhtwe.shared.Adapter.BaseAdapter
import com.theintsuhtwe.shared.Viewholders.BaseViewHolder

class DownloadPodCastAdapter (delegate : PodCastItemDelegate) : BaseAdapter<BaseViewHolder<DownloadVO>, DownloadVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownloadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_download_podcast, parent, false)
        return  DownloadViewHolder(view, mDelegate)
    }
}