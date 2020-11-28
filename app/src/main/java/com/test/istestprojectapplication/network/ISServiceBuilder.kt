package com.`is`.istestproject.network

import android.content.Context
import com.test.istestprojectapplication.core.SessionManager
import com.test.istestprojectapplication.data.remote.Constant
import com.test.istestprojectapplication.data.remote.api.ISLoginService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ISServiceBuilder(private val sessionManager: SessionManager) {
    private val clientBuilder = OkHttpClient.Builder()


    private val retrofit = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())


    fun getLoginService(): ISLoginService {
        return retrofit
            .client(clientBuilder.build())
            .build()
            .create(ISLoginService::class.java)
    }
}