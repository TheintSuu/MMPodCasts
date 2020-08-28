package com.theintsuhtwe.mmpodcasts.activities

import android.content.Context
import android.content.Intent

import android.media.MediaPlayer
import android.os.Build
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.layout_header.*
import kotlinx.android.synthetic.main.layout_playback_forward.*
import kotlinx.android.synthetic.main.layout_time_left.*
import java.sql.Time
import java.util.concurrent.TimeUnit

class PodCastDetailActivity : BaseActivity() {
    companion object {

        const val NEWS_ID_EXTRA = "PodCasts Id Extra"

        fun newItent(context: Context, newsId : Int): Intent {
            val intent =  Intent(context,  PodCastDetailActivity::class.java)
            intent.putExtra(NEWS_ID_EXTRA, newsId)
            return intent
        }
    }
    val default = intArrayOf(R.raw.somebody_to_u)

    lateinit var mediaPlayer : MediaPlayer
    lateinit var mediaController :MediaController
    var audioSong = 0
    var posSong = 0
    var dafSong = 0
    var handler = Handler()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pod_cast_detail)

        mediaController = MediaController(this)
        mediaPlayer = MediaPlayer()
        pbPodCast.max = 100
        pbPodCast.min = 0


        btnReplayTime2.setOnClickListener {  }

        btnPlay.setOnClickListener {
            audioPlay(0)
        }



    }
    fun milliSecondToString(ms : Int) : String{
        var detik = TimeUnit.MILLISECONDS.toSeconds(ms.toLong())
        val menit = TimeUnit.SECONDS.toMinutes(detik)
        detik = detik % 60
        return "$menit : $detik"
    }


     fun audioPlay(pos : Int){
         mediaPlayer = MediaPlayer.create(this, default[pos])
         pbPodCast.max = mediaPlayer.duration
         //tvMaxTime.setText(milliSecondToString(pbPodCast.max))
         tvTimeLong.setText(milliSecondToString(mediaPlayer.currentPosition))
         pbPodCast.progress = mediaPlayer.currentPosition


         mediaPlayer.start()
         var updateProgressBarThread = UpdateProgressBarThread()
         handler.postDelayed(updateProgressBarThread, 50)
     }

//    fun audioNext(){
//        if(mediaPlayer.isPlaying) mediaPlayer.stop()
//        if(posSong < (dafSong)){
//
//        }
//    }
    inner class UpdateProgressBarThread : Runnable{
        override fun run() {
           var currentTime = mediaPlayer.currentPosition
            tvTimeLong.setText(milliSecondToString(currentTime))
            pbPodCast.progress = currentTime
            if(currentTime != mediaPlayer.duration)  handler.postDelayed(this, 50)
        }

    }
}