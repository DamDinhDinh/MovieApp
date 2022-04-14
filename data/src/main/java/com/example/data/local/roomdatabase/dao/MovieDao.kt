package com.example.data.local.roomdatabase.dao

import androidx.room.*
import com.example.common.logs
import com.example.data.local.databasemodel.movie.*
import com.example.data.local.roomdatabase.databaseview.MovieGenreProductionCompany
import com.example.data.local.roomdatabase.databaseview.toEntity
import io.reactivex.rxjava3.core.Observable

@Dao
abstract class MovieDao {

    private val TAG = "MovieDao"

    fun insert(entities: List<EntityMovie>) {
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
    abstract fun _insert(
        entities: List<EntityMovie>,
        genres: List<EntityGenre>,
        companies: List<EntityProductionCompany>,
        movieGenres: List<EntityMovieGenre>,
        movieCompanies: List<EntityMovieProductionCompany>
    )

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(entities: List<EntityMovie>)

    @Delete
    abstract fun delete(entities: List<EntityMovie>)

    fun getMovieById(id: Int): Observable<EntityMovie> {
        return _getMovieById(id)
            .logs("$TAG database getMovieById id =$id")
            .map { it.toEntity() }
    }

    @Transaction
    @Query("SELECT * FROM movie WHERE movieId = :id")
    abstract fun _getMovieById(id: Int): Observable<MovieGenreProductionCompany>

    fun getMovieList(): Observable<List<EntityMovie>> {
        return _getMovieList()
            .logs("$TAG database getMovieList")
            .map { list -> list.map { it.toEntity() } }
    }

    @Transaction
    @Query("SELECT * FROM movie ORDER BY title")
    abstract fun _getMovieList(): Observable<List<MovieGenreProductionCompany>>

    fun getPopularMovie(): Observable<List<EntityMovie>> {
        return _getPopularMovie()
            .logs("$TAG database getPopularMovie")
            .map { list -> list.map { it.toEntity() } }
    }

    @Transaction
    @Query("SELECT * FROM movie ORDER BY popularity DESC")
    abstract fun _getPopularMovie(): Observable<List<MovieGenreProductionCompany>>
}