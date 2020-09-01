package com.theintsuhtwe.mmpodcasts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.views.viewholders.DownloadViewHolder

class DownloadPodCastAdapter (delegate : PodCastItemDelegate) : RecyclerView.Adapter<DownloadViewHolder>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownloadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_download_podcast, parent, false)
        return DownloadViewHolder(view, mDelegate)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: DownloadViewHolder, position: Int) {

    }

}