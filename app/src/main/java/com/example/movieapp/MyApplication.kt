package com.example.movieapp

import android.app.Application
import com.example.movieapp.di.AppComponent
import com.example.movieapp.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().build()
    }

}