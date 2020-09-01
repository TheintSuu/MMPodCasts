package com.theintsuhtwe.mmGenress.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.mmpodcasts.data.vos.GenresVO

interface GenresModel {
    fun getGenresFromApiSaveToDB(onSuccess:()->Unit,onError : (String)->Unit)


    fun getAllGenresList(onError:(String) ->Unit): LiveData<List<GenresVO>>
}