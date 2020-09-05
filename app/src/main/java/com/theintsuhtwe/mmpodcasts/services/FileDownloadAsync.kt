package com.theintsuhtwe.mmpodcasts.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import android.os.Environment
import android.os.Handler
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.activities.MainActivity
import com.theintsuhtwe.mmpodcasts.data.model.DownloadModelImpl
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.fragments.DownloadFragment
import com.theintsuhtwe.mmpodcasts.utils.DOWNLOAD
import com.theintsuhtwe.mmpodcasts.utils.FRAGMENT_Home
import java.io.*
import java.net.URL
import java.net.URLConnection


class FileDownloadAsync(
    private val context: Context,
    private val fileUrl: String,
    private val fileName: String,
    private val episodeVO: EpisodeVO
) :
    AsyncTask<Void, Void, Int>() {
    private var notificationManagerCompat: NotificationManagerCompat? = null
    private var notificationBuilder: NotificationCompat.Builder? = null
    private var success: Boolean = false
    override fun doInBackground(vararg params: Void?): Int {
        val rnds = (0..10).random()
        notificationManagerCompat = NotificationManagerCompat.from(context)
        val contentTitle = "Start Download"
        val notifyIntent = Intent(context, MainActivity::class.java)
        val fragment: Fragment = DownloadFragment()
//        val supportFragmentManager= context.applicationContext as FragmentActivity
//
//        supportFragmentManager.supportFragmentManager
//            .beginTransaction().
//            replace(R.id.container, fragment)
//            .addToBackStack(FRAGMENT_Home).commit()
        notifyIntent.putExtra(DOWNLOAD, Environment.DIRECTORY_DOWNLOADS)
        val notifyPendingIntent = PendingIntent.getActivity(
            context,
            rnds,
            notifyIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        notificationBuilder =
            createNotificationBuilder("downloader_channel")
        notificationBuilder?.setContentIntent(notifyPendingIntent)
        notificationBuilder?.setTicker("Start downloading from the server")
        notificationBuilder?.setOngoing(true)
        notificationBuilder?.setAutoCancel(false)
        notificationBuilder?.setSmallIcon(android.R.drawable.stat_sys_download)
        notificationBuilder?.setContentTitle(contentTitle)
        notificationBuilder?.setContentText("0%")
        notificationBuilder?.setProgress(100, 0, false)
        notificationManagerCompat?.notify(
            rnds,
            notificationBuilder?.build()!!
        )
        try {
            val tmpFile = File( Environment.getExternalStorageDirectory()
               ,  fileName)
            //val tmpFile = File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), fileName)
            val url = URL(fileUrl)
            val conection: URLConnection = url.openConnection()
            conection.connect()
            val fileLength: Int = conection.getContentLength()

            // input stream to read file - with 8k buffer
            val input: InputStream = BufferedInputStream(url.openStream(), 8192)

            // Output stream to write file

            val output: OutputStream = FileOutputStream(
                tmpFile
            )
//            val output: OutputStream = FileOutputStream(
//              tmpFile
//            )

            Environment.getStorageDirectory()
            val data = ByteArray(1024)
            var total: Long = 0
            var count: Int = 0
            var tmpPercentage = 0
            while (input.read(data).also { count = it } > 0) {
                total += count.toLong()
                output.write(data, 0, count)
                val percentage = (total * 100 / fileLength).toInt()
                if (percentage > tmpPercentage) {
                    tmpPercentage = percentage
                    notificationBuilder?.setContentText("$percentage%")
                    notificationBuilder?.setProgress(100, percentage, false)
                    notificationManagerCompat?.notify(
                        rnds,
                        notificationBuilder?.build()!!
                    )

                }
            }

            success = true
            // flushing output
            output.flush()

            // closing streams
            output.close()
            input.close()
        } catch (e: Exception) {
            success = false
        }

        return rnds
    }

    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        Handler().postDelayed(object : Runnable {
            override fun run() {
                val statusText =
                    if (success) "Done" else "Fail"
                val resId =
                    if (success) {
                        android.R.drawable.stat_sys_download_done
                    } else {
                        android.R.drawable.stat_notify_error
                    }

                if(success){
                    val downloadVO = DownloadVO(
                        path = fileName,
                        podcastInfo = episodeVO

                    )
                    DownloadModelImpl.insertDownloadPodCast(downloadVO)
                }
                notificationBuilder?.setContentTitle(fileName)
                notificationBuilder?.setSmallIcon(resId)
                notificationBuilder?.setOngoing(false)
                notificationBuilder?.setAutoCancel(true)
                notificationBuilder?.setContentText(statusText)
                notificationBuilder?.setProgress(0, 0, false)
                notificationManagerCompat?.notify(
                    result!!,
                    notificationBuilder?.build()!!
                )
            }
        }, 2000)

    }

    private fun createNotificationBuilder(channelId: String): NotificationCompat.Builder {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = context.getString(R.string.app_name)
            val notificationChannel =
                NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_LOW)
            notificationChannel.lightColor = context.getColor(R.color.colorPrimaryDark)
            notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE

            notificationManagerCompat?.createNotificationChannel(notificationChannel)

        }
        return NotificationCompat.Builder(context, channelId)
    }

}