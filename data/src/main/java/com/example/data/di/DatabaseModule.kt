package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.roomdatabase.MovieRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {
    companion object {
        @Provides
        @Singleton
        fun getDatabase(@ApplicationContext context:Context): MovieRoomDatabase {
            return Room.databaseBuilder(
                context,
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