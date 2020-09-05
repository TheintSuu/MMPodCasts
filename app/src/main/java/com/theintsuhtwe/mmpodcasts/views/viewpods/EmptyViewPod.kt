package com.theintsuhtwe.mmpodcasts.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.viw_pod_empty.view.*

class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setEmptyData(emptyMessage: String, emptyImageUrl: String) {


//        Glide.with(context)
//            .load(emptyImageUrl)
//            .into(ivEmptyImage)
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    private fun setUpListener() {
       btnReload.setOnClickListener {
            mDelegate?.onTapTryAgain()
        }
    }

    interface Delegate {
        fun onTapTryAgain()
    }

}