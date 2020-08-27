package com.theintsuhtwe.shared.mvp.presenter

import com.theintsuhtwe.shared.mvp.BaseView

interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)

}