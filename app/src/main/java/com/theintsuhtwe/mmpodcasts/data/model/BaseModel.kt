package com.theintsuhtwe.mmpodcasts.data.model

import android.content.Context
import android.text.TextUtils
import com.theintsuhtwe.mmpodcasts.BuildConfig
import com.theintsuhtwe.mmpodcasts.network.response.PodCastApi
import com.theintsuhtwe.mmpodcasts.persistence.db.PodCastDB
import com.theintsuhtwe.mmpodcasts.utils.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected var mPodCastApi: PodCastApi

    protected lateinit var mPodCastDB: PodCastDB
    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {

                val request = chain
                    .request()
                    .newBuilder()

               val apiKey = BuildConfig.X_ListenAPI_Key.toString()
                if (!TextUtils.isEmpty(apiKey)){
                    request.addHeader("Headers", "X-ListenAPI-Key $apiKey")
                }
                return chain.proceed(request.build())
            }
        })
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mPodCastApi = retrofit.create(PodCastApi::class.java)

    }

    fun initDatabase(context: Context) {
        mPodCastDB = PodCastDB.getDBInstance(context)
    }
}