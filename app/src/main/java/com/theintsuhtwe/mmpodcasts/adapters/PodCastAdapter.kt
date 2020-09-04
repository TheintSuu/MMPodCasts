package com.theintsuhtwe.mmpodcasts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.data.vos.PlayListItemVO
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.views.viewholders.PodCastViewHolder
import com.theintsuhtwe.shared.Adapter.BaseAdapter
import com.theintsuhtwe.shared.Viewholders.BaseViewHolder

class PodCastAdapter(delegate : PodCastItemDelegate) : BaseAdapter<BaseViewHolder<EpisodeVO>, EpisodeVO>() {
    val mDelegate = delegate
    val VIEW_TYPE_LARGE = 2244
    val VIEW_TYPE_SMALL = 1122
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodCastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_podcasts, parent, false)
        return PodCastViewHolder(view, mDelegate)
    }




}

//class PodCastAdapter(delegate : PodCastItemDelegate) : BaseAdapter<BaseViewHolder<PlayListItemVO>, PlayListItemVO>() {
//    val mDelegate = delegate
//    val VIEW_TYPE_LARGE = 2244
//    val VIEW_TYPE_SMALL = 1122
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodCastViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_podcasts, parent, false)
//        return PodCastViewHolder(view, mDelegate)
//    }
//
//
//
//
//}