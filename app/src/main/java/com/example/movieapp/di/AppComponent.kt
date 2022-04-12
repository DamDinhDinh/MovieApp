package com.example.movieapp.di

import com.example.data.di.ConfigModule
import com.example.data.di.DataModule
import com.example.data.di.NetWorkModule
import com.example.movieapp.presenter.moviedetail.MovieDetailFragment
import com.example.movieapp.presenter.moviepopularlist.MoviePopularListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetWorkModule::class, DataModule::class, ConfigModule::class, ViewModelFactoryModule::class])
interface AppComponent {

    fun inject(moviePopularListFragment: MoviePopularListFragment)

    fun inject(movieDetailFragment: MovieDetailFragment)
}