package com.example.movieapp

import android.app.Application
import com.example.movieapp.di.AppComponent
import com.example.movieapp.di.DaggerAppComponent
import com.example.movieapp.timber.MyDebugTree
import com.example.movieapp.timber.ReleaseTree
import timber.log.Timber

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().setApplication(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        if (!BuildConfig.DEBUG) {
            Timber.plant(ReleaseTree())
        } else {
            Timber.plant(MyDebugTree())
        }
    }

}