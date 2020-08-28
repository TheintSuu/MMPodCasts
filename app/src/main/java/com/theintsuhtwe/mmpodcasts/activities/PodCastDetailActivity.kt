package com.theintsuhtwe.mmpodcasts.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.shared.activities.BaseActivity

class PodCastDetailActivity : BaseActivity() {
    companion object {

        const val NEWS_ID_EXTRA = "PodCasts Id Extra"

        fun newItent(context: Context, newsId : Int): Intent {
            val intent =  Intent(context,  PodCastDetailActivity::class.java)
            intent.putExtra(NEWS_ID_EXTRA, newsId)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pod_cast_detail)
    }
}