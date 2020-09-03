package com.theintsuhtwe.mmpodcasts.views.viewholders

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.utils.loadImage
import com.theintsuhtwe.shared.Viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_podcasts.view.*
import kotlinx.android.synthetic.main.layout_playback_forward.view.*
import kotlinx.android.synthetic.main.layout_time_left.view.*

class PodCastViewHolder(itemView : View, delegate : PodCastItemDelegate) : BaseViewHolder<PodCastVO>(itemView){
    val mDelegate = delegate
    init{
        itemView.setOnClickListener {
            mData?.let {
               delegate.onTapPodCastItem(it.id)
            }


        }


    }



    override fun bindData(data: PodCastVO) {
        mData = data


        loadImage(
            itemView.context as Activity,
        data.image,
        itemView.ivPodcastImage)

        itemView.tvPodCastTimeLeft.text = data.audio_length_sec.toString()




            itemView.tvPodCastTitle.text = data.title


    }


}