package com.example.data.di

import androidx.room.Room
import com.example.data.local.roomdatabase.MovieRoomDatabase
import com.example.data.remote.api.ReviewApi
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            MovieRoomDatabase::class.java,
            "movie_room_database"
        ).build()
    }



    single { provideGenreDao(get()) }
    single { provideMovieDao(get()) }
    single { provideMovieGenreDao(get()) }
    single { provideProductionCompanyDao(get()) }
    single { provideMovieProductionCompanyDao(get()) }
    single { provideReviewDao(get()) }
}

fun provideGenreDao(movieRoomDatabase: MovieRoomDatabase) = movieRoomDatabase.getGenreDao()
fun provideMovieDao(movieRoomDatabase: MovieRoomDatabase) = movieRoomDatabase.getMovieDao()
fun provideMovieGenreDao(movieRoomDatabase: MovieRoomDatabase) = movieRoomDatabase.getMovieGenreDao()
fun provideProductionCompanyDao(movieRoomDatabase: MovieRoomDatabase) = movieRoomDatabase.getProductionCompanyDao()
fun provideMovieProductionCompanyDao(movieRoomDatabase: MovieRoomDatabase) = movieRoomDatabase.getMovieProductionCompanyDao()
fun provideReviewDao(movieRoomDatabase: MovieRoomDatabase) = movieRoomDatabase.getReviewDao()