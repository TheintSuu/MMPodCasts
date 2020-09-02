package com.theintsuhtwe.mmpodcasts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.data.vos.GenresVO
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.views.viewholders.CategoryViewHolder
import com.theintsuhtwe.shared.Adapter.BaseAdapter
import com.theintsuhtwe.shared.Viewholders.BaseViewHolder

class PodCastCategoryAdapter(delegate : PodCastItemDelegate) : BaseAdapter<BaseViewHolder<GenresVO>, GenresVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cateogry, parent, false)
        return CategoryViewHolder(view, mDelegate)
    }



}