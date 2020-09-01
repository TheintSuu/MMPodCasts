package com.theintsuhtwe.mmpodcasts.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmGenress.data.model.GenresModel
import com.theintsuhtwe.mmpodcasts.data.vos.GenresVO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object GenresModelImpl : GenresModel, BaseModel(){
    @SuppressLint("CheckResult")
    override fun getGenresFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {
      mPodCastApi
            .getAllGenres()
            .map { it.data.toMutableList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mPodCastDB.genresDao().insertAllGenres(it)
            },{
                onError(it.localizedMessage ?: it.localizedMessage)
            })
    }

    override fun getAllGenresList(onError: (String) -> Unit): LiveData<List<GenresVO>> {
        return mPodCastDB.genresDao().getAllGenres()
    }
}