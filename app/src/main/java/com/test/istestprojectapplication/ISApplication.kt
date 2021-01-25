package com.test.istestprojectapplication;

import android.app.Application;
import com.test.istestprojectapplication.di.app.AppModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ISApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
