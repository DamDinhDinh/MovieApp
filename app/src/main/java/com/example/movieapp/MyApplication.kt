package com.example.movieapp

import android.app.Application
import com.example.data.di.configModule
import com.example.data.di.databaseModule
import com.example.data.di.netWorkModule
import com.example.data.di.repoModule
import com.example.domain.di.useCaseModule
import com.example.movieapp.timber.MyDebugTree
import com.example.movieapp.timber.ReleaseTree
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (!BuildConfig.DEBUG) {
            Timber.plant(ReleaseTree())
        } else {
            Timber.plant(MyDebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(useCaseModule, netWorkModule, databaseModule, configModule, repoModule))
        }
    }

}