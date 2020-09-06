package com.theintsuhtwe.mmpodcasts.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.mmpodcasts.data.vos.GenresVO
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.mvp.view.CategoryView
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

interface CategoryPresenter : PodCastItemDelegate, BasePresenter<CategoryView> {
    fun onUiReady( lifecycleOwner: LifecycleOwner)

    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
}