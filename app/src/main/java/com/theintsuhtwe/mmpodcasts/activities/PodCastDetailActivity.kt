package com.theintsuhtwe.mmpodcasts.activities
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.widget.MediaController
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import com.google.android.exoplayer2.util.Util
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeDetailVO
import com.theintsuhtwe.mmpodcasts.mvp.presenter.DetailPresenter
import com.theintsuhtwe.mmpodcasts.mvp.presenter.DetailPresenterImpl
import com.theintsuhtwe.mmpodcasts.mvp.view.DetailView
import com.theintsuhtwe.mmpodcasts.utils.*
import com.theintsuhtwe.shared.activities.BaseActivity
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_pod_cast_detail.*
import kotlinx.android.synthetic.main.layout_header.*
import kotlinx.android.synthetic.main.layout_playback_forward.*
import kotlinx.android.synthetic.main.layout_time_left.*
import kotlinx.android.synthetic.main.mini_play_back_layout.*
import org.json.JSONObject
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

class PodCastDetailActivity : BaseActivity(), DetailView {

  var compositeDisposable  = CompositeDisposable()
    companion object {

        const val PodCasts_ID_EX = "PodCasts Id Extra"
        const val PodCasts_EX = "PodCasts  Extra"

        fun newItent(context: Context, newsId : String): Intent {
            val intent =  Intent(context,  PodCastDetailActivity::class.java)
            intent.putExtra(PodCasts_ID_EX, newsId)
            return intent
        }

        fun newItentWithEpisode(context: Context, episode : EpisodeDetailVO): Intent {
            val intent =  Intent(context,  PodCastDetailActivity::class.java)
            intent.putExtraJson(PodCasts_EX, episode)
            return intent
        }
    }


    private lateinit var mPresenter : DetailPresenter

    var mediaPlayer : MediaPlayer ?= null
    lateinit var mediaController :MediaController
    private var onTime: Int = 0
    private var playTime: Int = 0
    private var endTime: Int = 0
   
 


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pod_cast_detail)

        setUpPresenter()


        setUpMediaController()

        setUpListener()
        
        


        setUpDetail()


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


    private fun bindData(podCast : EpisodeDetailVO){

        loadImage(this@PodCastDetailActivity, podCast.image, ivMoviesImage)


        tvDetailDescription.text = fromHtmlToString(podCast.description)

        tvDetailPodCastCategory.text = podCast.podcast.genre_ids.last()

        //tvTimeLong.text = audioPlayTime(podCast.audio_length_sec)
        tvTimeLong.text = audioPlayTime(podCast.audio_length)

        tvPodCastTimeStart.setText(milliSecondToString(0))
        btnPlay.setImageDrawable(getDrawable(R.drawable.ic_baseline_play_circle_outline_24))
        tvPodCastTimeLeft.setText(milliSecondToString(mediaPlayer!!.duration))

        tvDetailTitle.text = podCast.title
        pbPodCast.progress = 0
        mPresenter.onTabAudioPlay(podCast.audio)
    }



    override fun displayAllPodCastDetail(detail: EpisodeDetailVO) {
        bindData(detail)
    }

    override fun playAudio(audio: String) {
        mediaPlayer = MediaPlayer.create(this, Uri.parse(audio))
//        if(audio.contains("https")){
//
//        }else{
//            mediaPlayer = MediaPlayer()
//            mediaPlayer!!.setDataSource(audio)
//            mediaPlayer!!.prepare()
//            mediaPlayer!!.start()
//        }



//        if(audio.contains("https")){
//            mediaPlayer = MediaPlayer().apply {
//                setAudioAttributes(
//                    AudioAttributes.Builder()
//                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                        .setUsage(AudioAttributes.USAGE_MEDIA)
//                        .build()
//                )
//                setDataSource(audio)
//            }
//
//        }else{
//                mediaPlayer = MediaPlayer().apply {
//                    setAudioAttributes(
//                        AudioAttributes.Builder()
//                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                            .setUsage(AudioAttributes.USAGE_MEDIA)
//                            .build()
//                    )
//                    setDataSource(applicationContext, Uri.parse(audio))
//                }
//
//        }


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

                compositeDisposable.add(io.reactivex.Observable.interval(1000L, TimeUnit.MILLISECONDS)
                    .timeInterval()
                    .subscribeOn(Schedulers.io( )).map {
                        if(mediaPlayer!!.isPlaying){
                            updateSeekBar()
                        }
                        return@map it

                    }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        if( mediaPlayer!!.currentPosition != mediaPlayer!!.duration){
                           UIUpdate()
                        }
                    }
                )









            }else{
                btnPlay.setImageDrawable(getDrawable(R.drawable.ic_baseline_play_circle_outline_24))
                mediaPlayer!!.pause()
            }

        }

        btnRew.setOnClickListener {
            if(mediaPlayer!!.isPlaying){
                if ((playTime - BackwardTime) > 0) {
                    playTime -= BackwardTime
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
                if ((playTime + ForwardTime) <= endTime) {
                    playTime += ForwardTime
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
        if(menit<10){
            if(detik<10){
                return "0$menit : 0$detik"
            }else{
                return "0$menit : $detik"
            }
        }else{
            if(detik<10){
                return "$menit : 0$detik"
            }else{
                return "$menit : $detik"
            }
        }


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

        }
    }





      private fun updateSeekBar() {

            endTime = mediaPlayer!!.duration

            playTime = mediaPlayer!!.currentPosition

            pbPodCast.max = endTime


        }

    private fun UIUpdate(){
        tvPodCastTimeStart.setText(milliSecondToString( mediaPlayer!!.currentPosition))
        tvPodCastTimeLeft.setText(milliSecondToString(endTime-mediaPlayer!!.currentPosition))
        pbPodCast.progress = mediaPlayer!!.currentPosition
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
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
            // playbackPosition = mediaPlayer!!.currentPosition.toLong()
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }
    
    private fun setUpDetail(){
        val podCastId = intent.getStringExtra(PodCasts_ID_EX)

        if(podCastId == null){
            val episodeDetailVO: EpisodeDetailVO? = intent.getJsonExtra(PodCasts_EX, EpisodeDetailVO::class.java)
            episodeDetailVO?.let { bindData(it) }

        }else {
            podCastId?.let { mPresenter.onUiReady(podCastId = it,
                lifecycleOwner = this@PodCastDetailActivity
            ) }
        }
    }



}
