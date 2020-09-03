package com.theintsuhtwe.mmpodcasts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.adapters.PodCastAdapter
import com.theintsuhtwe.mmpodcasts.adapters.PodCastCategoryAdapter
import com.theintsuhtwe.mmpodcasts.data.vos.GenresVO
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate
import com.theintsuhtwe.mmpodcasts.mvp.presenter.CategoryPresenter
import com.theintsuhtwe.mmpodcasts.mvp.presenter.CategoryPresenterImpl
import com.theintsuhtwe.mmpodcasts.mvp.presenter.MainPresenterImpl
import com.theintsuhtwe.mmpodcasts.mvp.view.CategoryView
import kotlinx.android.synthetic.main.fragment_download.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SearchFragment : Fragment(), CategoryView {

    private var param1: String? = null
    private var param2: String? = null

    lateinit var mMainAdapter: PodCastCategoryAdapter

    private lateinit var mPresenter : CategoryPresenter

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

        val v = inflater.inflate(R.layout.fragment_search, container, false)

        setUpPresenter()


        mPresenter.onUiReady(this)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRecycle()

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }





    override fun displayCategoryList(podCastsList: List<GenresVO>) {
      mMainAdapter.setData(podCastsList.toMutableList())
    }

    override fun navigateToPodCastByCategory(categoryId: String) {

    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(CategoryPresenterImpl::class.java)
        mPresenter.initPresenter(this)
        }

    private fun setUpRecycle(){
        mMainAdapter = PodCastCategoryAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mainRecyler.layoutManager = linearLayoutManager
        mainRecyler.adapter =  mMainAdapter
    }
}