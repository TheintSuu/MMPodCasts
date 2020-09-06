package com.theintsuhtwe.mmpodcasts.mvp.presenter

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.theintsuhtwe.mmpodcasts.data.model.GenresModelImpl
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.mvp.view.CategoryView
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter

class CategoryPresenterImpl : CategoryPresenter, AbstractBasePresenter<CategoryView>() {

    var mCategoryModel = GenresModelImpl


    override fun onUiReady( lifecycleOwner: LifecycleOwner) {
     getAllCategoryList(lifecycleOwner)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        getAllCategoryList(lifecycleOwner)
    }

    override fun onTapPodCastItem(value: String) {
        mView?.navigateToPodCastByCategory(value)
    }

    override fun onTapDownloadItem(episodeVO: EpisodeVO) {
    }

    private fun getAllCategoryList(lifecycleOwner: LifecycleOwner){
        mCategoryModel.getAllGenresList{
            mView?.enableSwipeRefresh()

        }.observe(lifecycleOwner, Observer {
            it?.let {
                mView?.disableSwipeRefresh()
                mView?.displayCategoryList(it)

                //mView?.displayDefaultCategory(it.first())
            }

        })
        mCategoryModel.getGenresFromApiSaveToDB(
            onSuccess = {

            },
            onError = {
                Log.d("Error","hello")
            })
    }
}