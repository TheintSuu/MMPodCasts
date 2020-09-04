package com.theintsuhtwe.mmpodcasts.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.theintsuhtwe.mmpodcasts.data.model.PodCastModelImpl
import com.theintsuhtwe.mmpodcasts.data.model.RecommendationModelImpl
import com.theintsuhtwe.mmpodcasts.mvp.view.MainView
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    var mPodCastModel = PodCastModelImpl
    var mPodCastRecModel = RecommendationModelImpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        requestAllPodCast(lifeCycleOwner)
    }

    override fun onRandomUIReady(lifeCycleOwner: LifecycleOwner) {


        mPodCastModel.getRandomPodCastFromApiSaveToDB(
            onSuccess = {

            },
            onError = {

            }
        )

        mPodCastModel.getRandomPodCast(onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.displayRandomPodCast(it)
        })


    }

    override fun onTabAudioPlay(podcastId: String) {
        mView?.navigateToPlayAudio(podcastId)
    }



    override fun onTapPodCastItem(value: String) {
        mView?.navigateToPodCastDetails(value)
    }



    private fun requestAllPodCast(lifeCycleOwner: LifecycleOwner) {

//        mPodCastModel.getAllPodCastList(onError = {
//        }).observe(lifeCycleOwner, Observer {
//            mView?.displayPodCastsList(it)
//        })
//
//
//        mPodCastModel.getPodCastFromApiSaveToDB(
//                onSuccess = {
//
//                },
//        onError = {
//
//        }
//        )

        mPodCastRecModel.getAllPodCastList(onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.displayPodCastsList(it)
        })


        mPodCastRecModel.getPodCastFromApiSaveToDB(
            onSuccess = {

            },
            onError = {

            }
        )

    }


}