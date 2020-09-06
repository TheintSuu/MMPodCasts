package com.theintsuhtwe.mmpodcasts.data.model




import com.theintsuhtwe.mmpodcasts.data.vos.DownloadVO


object DownloadModelImpl :DownloadModel, BaseModel() {
    override fun getDownloadPodCastById(id: Int): DownloadVO {
       return mPodCastDB.downloadDao().getdownloadById(id)
    }


    override fun getAllDownloadPodCastList(onError: (String) -> Unit): List<DownloadVO> {
       val list = mPodCastDB.downloadDao().getAlldownload()
        return list
    }

    override fun insertDownloadPodCast(episode: DownloadVO) {
        mPodCastDB.downloadDao().insertdownload(episode)
    }




}