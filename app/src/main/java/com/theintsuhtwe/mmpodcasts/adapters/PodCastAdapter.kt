package com.theintsuhtwe.mmpodcasts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.data.vos.PlayEpisodeListVO
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.views.viewholders.PodCastViewHolder
import com.theintsuhtwe.shared.Viewholders.BaseViewHolder

class PodCastAdapter(delegate : PodCastItemDelegate) : BaseAdapter<BaseViewHolder<PlayEpisodeListVO>, PlayEpisodeListVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodCastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_podcasts, parent, false)
        return PodCastViewHolder(view, mDelegate)
    }

    override fun getItemCount(): Int {
      return 10
    }

    override fun onBindViewHolder(holder: PodCastViewHolder, position: Int) {

    }

}