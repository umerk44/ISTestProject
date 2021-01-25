package com.test.istestprojectapplication.di

import android.content.Context
import com.test.istestprojectapplication.data.local.ISDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Provides
    fun provideDb(@ApplicationContext context: Context) = ISDatabase.getInstance(context)

    @Provides
    fun provideProductDao(isDatabase: ISDatabase) = isDatabase.getProductDao()
}