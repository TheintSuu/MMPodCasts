package com.theintsuhtwe.mmpodcasts.data.model



import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO
import com.theintsuhtwe.mmpodcasts.data.vos.EpisodeVO
import com.theintsuhtwe.mmpodcasts.data.vos.PlayListItemVO
import com.theintsuhtwe.mmpodcasts.utils.Play_List_ID_KEY
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object DownloadModelImpl :DownloadModel, BaseModel() {
    override fun getDownloadPodCastById(id: Int): DownloadVO {
       return mPodCastDB.downloadDao().getdownloadById(id)
    }


    override fun getAllDownloadPodCastList(onError: (String) -> Unit): List<DownloadVO> {
       return mPodCastDB.downloadDao().getAlldownload()
    }

    override fun insertDownloadPodCast(episode: DownloadVO) {
        mPodCastDB.downloadDao().insertdownload(episode)
    }




}