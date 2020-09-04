package com.theintsuhtwe.mmpodcasts.mvp.presenter

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.theintsuhtwe.mmpodcasts.data.model.GenresModelImpl
import com.theintsuhtwe.mmpodcasts.mvp.view.CategoryView
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter

class CategoryPresenterImpl : CategoryPresenter, AbstractBasePresenter<CategoryView>() {

    var mCategoryModel = GenresModelImpl


    override fun onUiReady( lifecycleOwner: LifecycleOwner) {
     getAllCategoryList(lifecycleOwner)
    }

    override fun onTapPodCastItem(value: String) {
        mView?.navigateToPodCastByCategory(value)
       // mView?.displayCategoryList(categoryList)
    }



    private fun getAllCategoryList(lifecycleOwner: LifecycleOwner){
        mCategoryModel.getAllGenresList{

        }.observe(lifecycleOwner, Observer {
            it?.let {
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