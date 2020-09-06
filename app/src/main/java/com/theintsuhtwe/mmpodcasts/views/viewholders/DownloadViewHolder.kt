package com.theintsuhtwe.mmpodcasts.views.viewholders

import android.app.Activity
import android.view.View
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO
import com.theintsuhtwe.mmpodcasts.delegate.DownloadPodcastItemDelegate
import com.theintsuhtwe.mmpodcasts.utils.audioPlayTime
import com.theintsuhtwe.mmpodcasts.utils.fromHtmlToString
import com.theintsuhtwe.mmpodcasts.utils.loadImage
import com.theintsuhtwe.shared.Viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_download_podcast.view.*
import kotlinx.android.synthetic.main.item_podcasts.view.ivPodcastImage
import kotlinx.android.synthetic.main.item_podcasts.view.tvPodCastTitle


class DownloadViewHolder (itemView : View, delegate : DownloadPodcastItemDelegate) : BaseViewHolder<DownloadVO>(itemView){
    val mDelegate = delegate
    init{
        itemView.setOnClickListener {
            mData?.let {
                it.let { it1 -> delegate.onTapPodCastItem(it1) }
            }
        }



    }



    override fun bindData(data: DownloadVO) {
        mData = data


        data.image?.let {
            loadImage(
                itemView.context as Activity,
                it,
                itemView.ivPodcastImage)
        }

        //itemView.tvPodCastTimeLeft.text = data.audio_length_sec.toString()
        itemView.tvPodCastHighLight.text = fromHtmlToString(data.description?.let { it })




        itemView.tvPodCastTitle.text = data.title


    }


}