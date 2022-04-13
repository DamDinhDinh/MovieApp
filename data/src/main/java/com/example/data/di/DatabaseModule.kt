package com.example.data.di

import android.app.Application
import androidx.room.Room
import com.example.data.local.databasemodel.roomdatabase.MovieRoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DatabaseModule {
    companion object {
        @Provides
        @Singleton
        fun getDatabase(application: Application): MovieRoomDatabase {
            return Room.databaseBuilder(
                application,
                MovieRoomDatabase::class.java,
                "movie_room_database"
            ).build()
        }

        @Provides
        fun getGenreDao(movieRoomDatabase: MovieRoomDatabase) =
            movieRoomDatabase.getGenreDao()

        @Provides
        fun getMovieDao(movieRoomDatabase: MovieRoomDatabase) =
            movieRoomDatabase.getMovieDao()

        @Provides
        fun getMovieGenreDao(movieRoomDatabase: MovieRoomDatabase) =
            movieRoomDatabase.getMovieGenreDao()

        @Provides
        fun getProductionCompanyDao(movieRoomDatabase: MovieRoomDatabase) =
            movieRoomDatabase.getProductionCompanyDao()

        @Provides
        fun getMovieProductionCompanyDao(movieRoomDatabase: MovieRoomDatabase) =
            movieRoomDatabase.getMovieProductionCompanyDao()

        @Provides
        fun getReviewDao(movieRoomDatabase: MovieRoomDatabase) =
            movieRoomDatabase.getReviewDao()
    }
}