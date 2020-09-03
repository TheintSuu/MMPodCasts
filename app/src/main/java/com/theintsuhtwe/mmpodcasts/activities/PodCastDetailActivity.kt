package com.theintsuhtwe.mmpodcasts.activities
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.widget.MediaController
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerControlView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.google.gson.JsonObject
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.data.vos.PodCastVO
import com.theintsuhtwe.mmpodcasts.mvp.presenter.DetailPresenter
import com.theintsuhtwe.mmpodcasts.mvp.presenter.DetailPresenterImpl
import com.theintsuhtwe.mmpodcasts.mvp.view.DetailView
import com.theintsuhtwe.mmpodcasts.utils.audioPlayTime
import com.theintsuhtwe.mmpodcasts.utils.loadImage
import com.theintsuhtwe.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_pod_cast_detail.*
import kotlinx.android.synthetic.main.layout_header.*
import kotlinx.android.synthetic.main.layout_playback_forward.*
import kotlinx.android.synthetic.main.layout_time_left.*
import kotlinx.android.synthetic.main.mini_play_back_layout.*
import org.json.JSONObject
import java.util.*
import java.util.concurrent.TimeUnit

class PodCastDetailActivity : BaseActivity(), DetailView {
    companion object {

        const val PodCasts_ID_EX = "PodCasts Id Extra"

        fun newItent(context: Context, newsId : String): Intent {
            val intent =  Intent(context,  PodCastDetailActivity::class.java)
            intent.putExtra(PodCasts_ID_EX, newsId)
            return intent
        }
    }
    val default = intArrayOf(R.raw.somebody_to_u)

    private lateinit var mPresenter : DetailPresenter

    var mediaPlayer : MediaPlayer ?= null
    lateinit var mediaController :MediaController
    private var onTime: Int = 0
    private var playTime: Int = 0
    private var endTime: Int = 0
    private var forwardTime: Int = 5000
    private var backwardTime: Int = 5000
    var handler = Handler()
    private var player: SimpleExoPlayer? = null
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition: Long = 0
    private var playerControlView : PlayerControlView?= null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pod_cast_detail)

        setUpPresenter()

        setUpListener()

        setUpMediaController()
        val podCastId = intent.getStringExtra(PodCasts_ID_EX)

        podCastId?.let { mPresenter.onUiReady(podCastId = it,
            lifecycleOwner = this@PodCastDetailActivity
        ) }


    }


    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun setUpMediaController(){
        mediaController = MediaController(this)
        mediaPlayer = MediaPlayer()

        pbPodCast.max = 100
        pbPodCast.min = 0
    }


    private fun bindData(podCast : PodCastVO){
        loadImage(this@PodCastDetailActivity, podCast.image, ivMoviesImage)

        tvDetailDescription.text = podCast.description

        tvTimeLong.text = audioPlayTime(podCast.audio_length_sec)

        tvDetailTitle.text = podCast.title

        mPresenter.onTabAudioPlay(podCast.audio)
    }

    override fun displayAllPodCastDetail(detail: PodCastVO) {
        bindData(detail)
    }

    override fun playAudio(audio: String) {
        mediaPlayer = MediaPlayer.create(this, Uri.parse(audio))

        val deque: Deque<JSONObject> = ArrayDeque()
    }

    private fun setUpListener(){

        btnPlay.setOnClickListener {
            if(!(mediaPlayer?.isPlaying)!!){
                mediaPlayer?.start()

                endTime = mediaPlayer!!.duration

                playTime = mediaPlayer!!.currentPosition

                pbPodCast.max = endTime

                onTime = 1

                btnPlay.setImageDrawable(getDrawable(R.drawable.ic_baseline_pause_circle_outline_24))
                tvPodCastTimeStart.setText(milliSecondToString( mediaPlayer!!.currentPosition))
                tvPodCastTimeLeft.setText(milliSecondToString(endTime-mediaPlayer!!.currentPosition))
                pbPodCast.progress = mediaPlayer!!.currentPosition
            }else{
                btnPlay.setImageDrawable(getDrawable(R.drawable.ic_baseline_play_circle_outline_24))
                mediaPlayer!!.pause()
            }

        }

        btnRew.setOnClickListener {
            if(mediaPlayer!!.isPlaying){
                if ((playTime - backwardTime) > 0) {
                    playTime -= backwardTime
                    mediaPlayer!!.seekTo(playTime)
                }
                else {
                    Toast.makeText(
                        applicationContext,
                        "Cannot jump backward 5 seconds",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }

        btnForward.setOnClickListener {
            if(mediaPlayer!!.isPlaying){
                if ((playTime + forwardTime) <= endTime) {
                    playTime += forwardTime
                    mediaPlayer!!.seekTo(playTime)
                }
                else {
                    Toast.makeText(
                        applicationContext,
                        "Cannot jump forward 5 seconds",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        pbPodCast.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                if(mediaPlayer!!.isPlaying && pbPodCast.progress <= endTime){
                    mediaPlayer!!.seekTo(pbPodCast.progress)
                }
               // pbPodCast.progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext,"start tracking",Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext,"stop tracking",Toast.LENGTH_SHORT).show()
            }
        }
        )
    }

    fun milliSecondToString(ms : Int) : String{
        var detik = TimeUnit.MILLISECONDS.toSeconds(ms.toLong())
        val menit = TimeUnit.SECONDS.toMinutes(detik)
        detik = detik % 60
        return "$menit : $detik"
    }


    fun audioPlay(url : String){



        if(mediaPlayer!!.isPlaying){

            mediaPlayer!!.pause()
        }else{
            pbPodCast.max = mediaPlayer!!.duration
            //tvMaxTime.setText(milliSecondToString(pbPodCast.max))
            tvPodCastTimeLeft.setText(milliSecondToString(mediaPlayer!!.currentPosition))
            pbPodCast.progress = mediaPlayer!!.currentPosition

            btnPlay.setImageDrawable(getDrawable(R.drawable.ic_baseline_pause_circle_outline_24))
            mediaPlayer!!.start()
            var updateProgressBarThread = UpdateProgressBarThread()
            handler.postDelayed(updateProgressBarThread, 50)
        }
    }


    inner class UpdateProgressBarThread : Runnable{
        override fun run() {
            playTime = mediaPlayer!!.currentPosition
            tvPodCastTimeLeft.setText(milliSecondToString(mediaPlayer!!.currentPosition))
            pbPodCast.progress = mediaPlayer!!.currentPosition
            if(playTime != mediaPlayer!!.duration)  handler.postDelayed(this, 50)
        }

    }




    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        //if (Util.SDK_INT <= 23 || player == null) {
            setUpMediaController()
       // }
    }

    override fun onPause() {
        super.onPause()
       // if (Util.SDK_INT <= 23) {
            releasePlayer()
       // }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {
            releasePlayer()
        }
    }





    private fun releasePlayer() {
        if (mediaPlayer != null) {
            playbackPosition = mediaPlayer!!.currentPosition.toLong()
           // currentWindow = player!!.getCurrentWindowIndex()
            //playWhenReady = player!!.getPlayWhenReady()
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }

}
