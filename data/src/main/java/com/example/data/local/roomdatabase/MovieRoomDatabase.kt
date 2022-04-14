package com.example.data.local.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.local.databasemodel.movie.*
import com.example.data.local.databasemodel.review.EntityReview
import com.example.data.local.roomdatabase.dao.*
import com.example.data.local.roomdatabase.typeconverter.MovieTypeConverters
import com.example.data.local.roomdatabase.typeconverter.ReviewTypeConverters

@Database(
    entities = [EntityMovie::class,
        EntityGenre::class,
        EntityMovieGenre::class,
        EntityProductionCompany::class,
        EntityMovieProductionCompany::class,
        EntityReview::class],
    version = DatabaseVersionLog.VERSION_1,
)
@TypeConverters(MovieTypeConverters::class, ReviewTypeConverters::class)
abstract class MovieRoomDatabase : RoomDatabase() {

    abstract fun getGenreDao(): GenreDao

    abstract fun getMovieDao(): MovieDao

    abstract fun getMovieGenreDao(): MovieGenreDao

    abstract fun getProductionCompanyDao(): ProductionCompanyDao

    abstract fun getMovieProductionCompanyDao(): MovieProductionCompanyDao

    abstract fun getReviewDao(): ReviewDao
}