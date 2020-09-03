package com.theintsuhtwe.mmpodcasts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.activities.PodCastDetailActivity
import com.theintsuhtwe.mmpodcasts.adapters.PodCastAdapter
import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO
import com.theintsuhtwe.mmpodcasts.mvp.presenter.MainPresenter
import com.theintsuhtwe.mmpodcasts.mvp.presenter.MainPresenterImpl
import com.theintsuhtwe.mmpodcasts.mvp.view.MainView
import com.theintsuhtwe.mmpodcasts.utils.audioPlayTime
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

    override fun displayRandomPodCast(podCast: PodCastVO) {
        if(podCast != null && podCast.explicit_content!= null){
            tvPlaybackHomeDescription.text = podCast.description
            tvPlaybackDescription.text= podCast.description
            tvPlaybackTitle.text = podCast.title
            tvPodCastTimeLeft.text = audioPlayTime(podCast.audio_length_sec)
            activity?.let { loadImage(it, podCast.image, exo_rev ) }
        }




    }

    override fun displayPodCastsList(podCastsList: List<PodCastVO>) {
       mMainAdapter.setData(podCastsList.toMutableList())
    }

    override fun navigateToPodCastDetails(podCastId: String) {
        startActivity(PodCastDetailActivity.newItent(activity!!, podCastId))
    }

    override fun navigateToPlayAudio(podCastId: String) {
        startActivity(PodCastDetailActivity.newItent(activity!!, podCastId))
    }


}