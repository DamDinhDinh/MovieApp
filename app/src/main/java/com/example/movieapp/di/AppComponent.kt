package com.example.movieapp.di

import android.app.Application
import com.example.data.di.ConfigModule
import com.example.data.di.DataModule
import com.example.data.di.DatabaseModule
import com.example.data.di.NetWorkModule
import com.example.movieapp.presenter.moviedetail.AboutMovieFragment
import com.example.movieapp.presenter.moviedetail.MovieDetailFragment
import com.example.movieapp.presenter.moviedetail.ReviewMovieFragment
import com.example.movieapp.presenter.movielist.MovieListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetWorkModule::class, DataModule::class, ConfigModule::class, DatabaseModule::class])
abstract class AppComponent {

    abstract fun inject(movieListFragment: MovieListFragment)

    abstract fun inject(movieDetailFragment: MovieDetailFragment)

    abstract fun inject(aboutMovieFragment: AboutMovieFragment)

    abstract fun inject(reviewMovieFragment: ReviewMovieFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setApplication(application: Application): Builder

        fun build(): AppComponent
    }
}