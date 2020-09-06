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
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.activities.PodCastDetailActivity
import com.theintsuhtwe.mmpodcasts.adapters.PodCastAdapter
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.mvp.presenter.MainPresenter
import com.theintsuhtwe.mmpodcasts.mvp.presenter.MainPresenterImpl
import com.theintsuhtwe.mmpodcasts.mvp.view.MainView
import com.theintsuhtwe.mmpodcasts.services.FileDownloadAsync
import com.theintsuhtwe.mmpodcasts.utils.STORAGE_PERMISSION_CODE
import com.theintsuhtwe.mmpodcasts.utils.audioPlayTime
import com.theintsuhtwe.mmpodcasts.utils.fromHtmlToString
import com.theintsuhtwe.mmpodcasts.utils.loadImage
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_playback_control_view.*
import kotlinx.android.synthetic.main.layout_time_left.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), MainView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var mMainAdapter: PodCastAdapter

    lateinit var mPresenter : MainPresenter
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
        val v = inflater.inflate(R.layout.fragment_home, container, false)

        setUpPresenter()

        mPresenter.onUiReady(this)

        mPresenter.onRandomUIReady(this)


        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpSwipeRefresh()

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
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){
        mMainAdapter = PodCastAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvPodCastUpNext.layoutManager = linearLayoutManager
        rvPodCastUpNext.adapter =  mMainAdapter

    }

    override fun displayRandomPodCast(podCast: EpisodeVO) {

        podCast?.let {podCast
            tvPlaybackHomeDescription.text = fromHtmlToString(podCast.description)
            tvPlaybackDescription.text= podCast.description
            tvPlaybackTitle.text = podCast.title
            //tvPodCastTimeLeft.text = audioPlayTime(podCast.audio_length_sec)
            tvPodCastTimeLeft.text = audioPlayTime(podCast.audio_length)
            activity?.let { loadImage(it, podCast.image, exo_rev ) }
        }






    }

    override fun displayPodCastsList(podCastsList: List<EpisodeVO>) {
        mMainAdapter.setData(podCastsList.toMutableList())
    }

//    override fun displayPodCastsList(podCastsList: List<PlayListItemVO>) {
//       mMainAdapter.setData(podCastsList.toMutableList())
//    }

    override fun navigateToPodCastDetails(podCastId: String) {
        startActivity(PodCastDetailActivity.newItent(activity!!, podCastId))
    }

    override fun navigateToPlayAudio(podCastId: String) {
        startActivity(PodCastDetailActivity.newItent(activity!!, podCastId))
    }

    override fun navigateToDownloadAudio(episodeVO: EpisodeVO) {
        AlertDialog.Builder(activity!!)
            .setMessage("Are you sure to download?")
            .setCancelable(false)
            .setPositiveButton(android.R.string.ok) { dialog, which -> startDownload(episodeVO)}
            .create().show()

    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }


    private fun startDownload(episodeVO: EpisodeVO){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    activity!!,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) ==
                PackageManager.PERMISSION_DENIED
            ) {
                requestPermissions(
                    arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    STORAGE_PERMISSION_CODE
                )
            } else {
                val saveFileName = episodeVO.title
                val filePath = episodeVO.audio
                FileDownloadAsync(activity!!, filePath!!, saveFileName!!, episodeVO).execute()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            STORAGE_PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    AlertDialog.Builder(activity!!)
                        .setMessage("Permission Denied")
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.ok) { dialog, which -> }
                        .create().show()
                }
            }
        }
    }



    private fun setUpSwipeRefresh(){
        swipeRefreshLayout.setOnRefreshListener {
            mPresenter.onSwipeRefresh(this)
        }

    }
}