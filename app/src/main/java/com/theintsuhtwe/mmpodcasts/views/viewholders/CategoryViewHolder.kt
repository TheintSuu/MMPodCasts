package com.theintsuhtwe.mmpodcasts.views.viewholders

import android.view.View
import com.theintsuhtwe.mmpodcasts.data.vos.GenresVO
import com.theintsuhtwe.mmpodcasts.data.vos.PlayEpisodeListVO
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.shared.Viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_cateogry.view.*

class CategoryViewHolder(itemView : View, delegate : PodCastItemDelegate) :  BaseViewHolder<GenresVO>(itemView) {
    val mDelegate = delegate
    init{
        itemView.setOnClickListener {
            mData?.let {
                //delegate.onTapPodCastItem(it.id)
            }
        }
    }

    override fun bindData(data: GenresVO) {
        itemView.tvCategoryTypeTitle.text = data.name
    }


}