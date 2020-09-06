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
import com.theintsuhtwe.mmpodcasts.adapters.DownloadPodCastAdapter
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeDetailVO
import com.theintsuhtwe.mmpodcasts.mvp.presenter.DownloadPresenter
import com.theintsuhtwe.mmpodcasts.mvp.presenter.DownloadPresenterImpl
import com.theintsuhtwe.mmpodcasts.mvp.view.DownloadView
import com.theintsuhtwe.mmpodcasts.views.viewpods.EmptyViewPod
import kotlinx.android.synthetic.main.fragment_download.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DownloadFragment : Fragment(), DownloadView{

    private var param1: String? = null
    private var param2: String? = null

    lateinit var mDownloadAdapter: DownloadPodCastAdapter

    lateinit var mPresenter : DownloadPresenter

    private lateinit var mviewPodEmpty: EmptyViewPod


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DownloadFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

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

        setUpAdapter()

       // setUpViewPod()

        mPresenter.onUiReady(this)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpViewPod()

        setUpRecyclerView()

    }

    override fun displayDownloadPodCastsList(podCastsList: List<DownloadVO>) {
        mDownloadAdapter.setData(podCastsList.toMutableList())
    }

    override fun navigateToPodCastDetails(episode: EpisodeDetailVO) {
        startActivity(PodCastDetailActivity.newItentWithEpisode(activity!!, episode))
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(DownloadPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){

        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mainRecylerDownload.layoutManager = linearLayoutManager
        mainRecylerDownload.adapter =  mDownloadAdapter

        mainRecylerDownload.setEmptyView(mviewPodEmpty)

    }

    private fun setUpViewPod() {
        mviewPodEmpty = vpEmpty as EmptyViewPod
       // mviewPodEmpty.setEmptyData(EM_NO_NEWS_AVAILABLE, EMPTY_IMAGE_URL)
        mviewPodEmpty.setDelegate(mPresenter)
    }


    private  fun setUpAdapter(){
        mDownloadAdapter = DownloadPodCastAdapter(mPresenter)
    }




}