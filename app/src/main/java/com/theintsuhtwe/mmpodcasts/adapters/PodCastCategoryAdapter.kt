package com.theintsuhtwe.mmpodcasts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.views.viewholders.CategoryViewHolder

class PodCastCategoryAdapter(delegate : PodCastItemDelegate) : RecyclerView.Adapter<CategoryViewHolder>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cateogry, parent, false)
        return CategoryViewHolder(view, mDelegate)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

    }

}