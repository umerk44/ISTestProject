package com.test.istestprojectapplication.di.app

import android.content.Context
import com.test.istestprojectapplication.core.NetworkInterceptor
import com.test.istestprojectapplication.core.SessionManager
import com.test.istestprojectapplication.data.remote.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class AppModule() {

    private val clientBuilder by lazy {   OkHttpClient.Builder() }

    @Provides
    @Singleton
    fun sessionManager(@ApplicationContext context: Context) = SessionManager(context)


    @Provides
    @Singleton
    @RetrofitWithInterceptor
    fun retrofitSimple(networkInterceptor: NetworkInterceptor) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder.addInterceptor(networkInterceptor).build())
            .build()

    }


    @Provides
    @Singleton
    @RetrofitSimple
    fun retrofitWithInterceptor() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder.build())
            .build()

    }
}