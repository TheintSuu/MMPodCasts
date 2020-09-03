package com.theintsuhtwe.mmpodcasts.mvp.view

import com.theintsuhtwe.mmpodcasts.data.vos.GenresVO
import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO
import com.theintsuhtwe.shared.mvp.BaseView

interface CategoryView : BaseView {

    fun displayCategoryList(podCastsList : List<GenresVO>)

    fun navigateToPodCastByCategory(categoryId: String)
}