package com.example.data.di

import androidx.room.Room
import com.example.data.local.roomdatabase.MovieRoomDatabase
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

    single { (movieRoomDatabase: MovieRoomDatabase) -> movieRoomDatabase.getGenreDao() }
    single { (movieRoomDatabase: MovieRoomDatabase) -> movieRoomDatabase.getMovieDao() }
    single { (movieRoomDatabase: MovieRoomDatabase) -> movieRoomDatabase.getMovieGenreDao() }
    single { (movieRoomDatabase: MovieRoomDatabase) -> movieRoomDatabase.getProductionCompanyDao() }
    single { (movieRoomDatabase: MovieRoomDatabase) -> movieRoomDatabase.getMovieProductionCompanyDao() }
    single { (movieRoomDatabase: MovieRoomDatabase) -> movieRoomDatabase.getReviewDao() }
}