package com.theintsuhtwe.mmpodcasts.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.activities.PodCastDetailActivity
import com.theintsuhtwe.mmpodcasts.adapters.DownloadPodCastAdapter
import com.theintsuhtwe.mmpodcasts.adapters.PodCastAdapter
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO
import com.theintsuhtwe.mmpodcasts.mvp.presenter.DownloadPresenter
import com.theintsuhtwe.mmpodcasts.mvp.presenter.DownloadPresenterImpl
import com.theintsuhtwe.mmpodcasts.mvp.presenter.MainPresenterImpl
import com.theintsuhtwe.mmpodcasts.mvp.view.DownloadView
import com.theintsuhtwe.mmpodcasts.services.FileDownloadAsync
import com.theintsuhtwe.mmpodcasts.utils.STORAGE_PERMISSION_CODE
import com.theintsuhtwe.mmpodcasts.utils.audioPlayTime
import com.theintsuhtwe.mmpodcasts.utils.loadImage
import com.theintsuhtwe.mmpodcasts.views.viewpods.EmptyViewPod
import kotlinx.android.synthetic.main.fragment_download.*

import kotlinx.android.synthetic.main.layout_playback_control_view.*
import kotlinx.android.synthetic.main.layout_time_left.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DownloadFragment : Fragment(), DownloadView{

    private var param1: String? = null
    private var param2: String? = null

    lateinit var mMainAdapter: DownloadPodCastAdapter

    //private lateinit var mViewPodEmpty: EmptyViewPod

    lateinit var mPresenter : DownloadPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragmentDow
        val v = inflater.inflate(R.layout.fragment_download, container, false)


        setUpPresenter()

       // setUpViewPod()

        mPresenter.onUiReady(this)


        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setUpRecyclerView()

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(DownloadPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){
        mMainAdapter = DownloadPodCastAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mainRecyler.layoutManager = linearLayoutManager
        mainRecyler.adapter =  mMainAdapter

    }


    override fun displayDownloadPodCastsList(podCastsList: List<DownloadVO>) {
       mMainAdapter.setData(podCastsList.toMutableList())
    }

    override fun navigateToPodCastDetails(episodeId: String) {
        startActivity(PodCastDetailActivity.newItent(activity!!, episodeId))
    }

//    private fun setUpViewPod() {
//        mViewPodEmpty = vpEmpty as EmptyViewPod
//        mViewPodEmpty.setDelegate(mPresenter)
//    }


}