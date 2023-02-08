package com.example.data.local.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.movie.*
import com.example.data.local.roomdatabase.databaseview.MovieGenreProductionCompany
import com.example.data.local.roomdatabase.databaseview.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Dao
abstract class MovieDao {

    private val TAG = "MovieDao"

    suspend fun insert(entities: List<EntityMovie>) {
        for (movie in entities) {
            val movieGenres: List<EntityMovieGenre> = movie.genres.map { genre ->
                EntityMovieGenre(
                    movieId = movie.id,
                    genreId = genre.id
                )
            }
            val companies: List<EntityMovieProductionCompany> = movie.genres.map { company ->
                EntityMovieProductionCompany(
                    movieId = movie.id,
                    companyId = company.id
                )
            }
            _insert(listOf(movie), movie.genres, movie.productionCompanies, movieGenres, companies)
        }
    }

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract suspend fun _insert(
        entities: List<EntityMovie>,
        genres: List<EntityGenre>,
        companies: List<EntityProductionCompany>,
        movieGenres: List<EntityMovieGenre>,
        movieCompanies: List<EntityMovieProductionCompany>
    )

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update(entities: List<EntityMovie>)

    @Delete
    abstract suspend fun delete(entities: List<EntityMovie>)

    fun getMovieById(id: String): Flow<EntityMovie> {
        return _getMovieById(id)
            .map { it.toEntity() }
    }

    @Transaction
    @Query("SELECT * FROM movie WHERE movieId = :id")
    protected abstract fun _getMovieById(id: String): Flow<MovieGenreProductionCompany>

    fun getMovieList(): Flow<List<EntityMovie>> {
        return _getMovieList()
            .map { list -> list.map { it.toEntity() } }
    }

    @Transaction
    @Query("SELECT * FROM movie ORDER BY title")
    protected abstract fun _getMovieList(): Flow<List<MovieGenreProductionCompany>>

    fun getPopularMovie(): Flow<List<EntityMovie>> {
        return _getPopularMovie()
            .map { list -> list.map { it.toEntity() } }
    }

    @Transaction
    @Query("SELECT * FROM movie ORDER BY popularity DESC")
    protected abstract fun _getPopularMovie(): Flow<List<MovieGenreProductionCompany>>
}