package com.test.istestprojectapplication.di

import com.test.istestprojectapplication.data.remote.api.ISLoginService
import com.test.istestprojectapplication.data.remote.api.ProductsService
import com.test.istestprojectapplication.di.app.RetrofitSimple
import com.test.istestprojectapplication.di.app.RetrofitWithInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

@Module
@InstallIn(ApplicationComponent::class)
class ServiceModule {

    @Provides
    fun getLoginService(@RetrofitWithInterceptor retrofit : Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }

    @Provides
    fun getProductService(@RetrofitSimple retrofit : Retrofit): ISLoginService {
        return retrofit.create(ISLoginService::class.java)
    }
}