package com.theintsuhtwe.mmpodcasts.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout

class EmptyViewPod @JvmOverloads constructor(
    context : Context, attrs: AttributeSet ?= null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate : Delegate ?= null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setEmptyData(emptyMessage : String, emptyImageUrl : String){

    }

    fun setDelegate(delegate : Delegate){
        mDelegate = delegate
    }

    private  fun setUpListener(){

    }

    interface  Delegate{
        fun onTapTryAgain()
    }
}