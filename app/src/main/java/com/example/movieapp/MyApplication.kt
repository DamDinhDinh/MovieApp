package com.example.movieapp

import android.app.Application
import com.example.movieapp.timber.MyDebugTree
import com.example.movieapp.timber.ReleaseTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (!BuildConfig.DEBUG) {
            Timber.plant(ReleaseTree())
        } else {
            Timber.plant(MyDebugTree())
        }
    }

}