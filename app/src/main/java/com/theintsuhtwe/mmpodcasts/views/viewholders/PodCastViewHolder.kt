package com.theintsuhtwe.mmpodcasts.views.viewholders

import android.app.Activity
import android.view.View
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.utils.audioPlayTime
import com.theintsuhtwe.mmpodcasts.utils.loadImage
import com.theintsuhtwe.shared.Viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_podcasts.view.*
import kotlinx.android.synthetic.main.layout_time_left.view.*

class PodCastViewHolder(itemView : View, delegate : PodCastItemDelegate) : BaseViewHolder<EpisodeVO>(itemView){
    val mDelegate = delegate
    init{
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapPodCastItem(it.id)
            }


        }

        itemView.btnAudioDownload
            .setOnClickListener {
                mData?.let {
                    delegate.onTapDownloadItem(it)
                }
            }


    }



    override fun bindData(data: EpisodeVO) {
        mData = data


        loadImage(
            itemView.context as Activity,
            data.image,
            itemView.ivPodcastImage)

        //itemView.tvPodCastTimeLeft.text = data.audio_length_sec.toString()
        itemView.tvPodCastTimeLeft.text = audioPlayTime(data.audio_length)




        itemView.tvPodCastTitle.text = data.title


    }


}


//class PodCastViewHolder(itemView : View, delegate : PodCastItemDelegate) : BaseViewHolder<PlayListItemVO>(itemView) {
//    val mDelegate = delegate
//
//    init {
//        itemView.setOnClickListener {
//            mData?.let {
//                delegate.onTapPodCastItem(it.episode.id)
//            }
//
//
//        }
//
//
//    }
//
//
//    override fun bindData(data: PlayListItemVO) {
//        mData = data
//
//
//        loadImage(
//            itemView.context as Activity,
//            data.episode.image,
//            itemView.ivPodcastImage
//        )
//
//        itemView.tvPodCastTimeLeft.text = data.episode.audio_length_sec.toString()
//
//
//
//
//        itemView.tvPodCastTitle.text = data.episode.title
//
//
//    }
//
//}