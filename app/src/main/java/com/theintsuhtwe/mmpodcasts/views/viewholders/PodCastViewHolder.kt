package com.theintsuhtwe.mmpodcasts.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.shared.Viewholders.BaseViewHolder

class PodCastViewHolder(itemView : View, delegate : PodCastItemDelegate) : RecyclerView.ViewHolder(itemView){
    val mDelegate = delegate
    init{
        itemView.setOnClickListener {
            mDelegate.onTapPodCastItem(it.id)

        }
    }
//    override fun bindData(data: Int) {
//
//    }

}