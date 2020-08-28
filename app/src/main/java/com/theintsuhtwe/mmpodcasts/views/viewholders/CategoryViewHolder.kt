package com.theintsuhtwe.mmpodcasts.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate

class CategoryViewHolder(itemView : View, delegate : PodCastItemDelegate) : RecyclerView.ViewHolder(itemView){
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