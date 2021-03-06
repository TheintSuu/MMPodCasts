package com.theintsuhtwe.mmpodcasts.data.model

import android.content.Context
import android.text.TextUtils
import com.google.gson.GsonBuilder
import com.theintsuhtwe.mmpodcasts.BuildConfig
import com.theintsuhtwe.mmpodcasts.network.response.PodCastApi
import com.theintsuhtwe.mmpodcasts.persistence.db.PodCastDB
import com.theintsuhtwe.mmpodcasts.utils.BASE_TEST_URL
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

    protected lateinit var mPodCastTestApi: PodCastApi

    protected lateinit var mPodCastDB: PodCastDB
    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {


                val apiKey = BuildConfig.X_ListenAPI_Key
                val request = chain
                    .request()

                    .newBuilder()
                    .addHeader("X-ListenAPI-Key", apiKey)

//
//                if (!TextUtils.isEmpty(apiKey)){
//                    request.addHeader("Headers", "X-ListenAPI-Key $apiKey")
//                }
                return chain.proceed(request.build())
            }
        })
            .build()



        val mOkHttpTestClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {


                    val apiKey = "c77eca3497mshe91c827502a5a8bp16aecfjsn5a4b9bde0899"
                    val request = chain
                        .request()

                        .newBuilder()
                        .addHeader("X-RapidAPI-Key", apiKey)

//
//                if (!TextUtils.isEmpty(apiKey)){
//                    request.addHeader("Headers", "X-ListenAPI-Key $apiKey")
//                }
                    return chain.proceed(request.build())
                }
            })
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


        val retrofitTest = Retrofit.Builder()
            .baseUrl(BASE_TEST_URL)
            .client(mOkHttpTestClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mPodCastApi = retrofit.create(PodCastApi::class.java)
        mPodCastTestApi = retrofitTest.create(PodCastApi::class.java)

    }

    fun initDatabase(context: Context) {
        mPodCastDB = PodCastDB.getDBInstance(context)
    }
}