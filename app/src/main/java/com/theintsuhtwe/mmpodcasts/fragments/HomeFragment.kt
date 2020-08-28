package com.theintsuhtwe.mmpodcasts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.activities.PodCastDetailActivity
import com.theintsuhtwe.mmpodcasts.adapters.PodCastAdapter
import kotlinx.android.synthetic.main.fragment_download.*
import kotlinx.android.synthetic.main.fragment_home.*
import com.theintsuhtwe.mmpodcasts.delegate.PodCastItemDelegate as PodCastItemDelegate1

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), PodCastItemDelegate1 {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var mMainAdapter: PodCastAdapter
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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mMainAdapter = PodCastAdapter(this)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
       rvPodCastUpNext.layoutManager = linearLayoutManager
        rvPodCastUpNext.adapter =  mMainAdapter

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

    override fun onTapPodCastItem(value: Int) {
        startActivity(PodCastDetailActivity.newItent(activity!!, 0))
    }
}