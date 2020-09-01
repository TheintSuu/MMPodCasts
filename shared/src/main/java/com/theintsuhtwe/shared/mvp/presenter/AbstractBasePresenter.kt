package com.theintsuhtwe.shared.mvp.presenter

import androidx.lifecycle.ViewModel
import com.theintsuhtwe.shared.mvp.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}