package com.example.data.repo

import com.example.common.dataSchedulers
import com.example.common.logs
import com.example.data.local.mapper.movie.toEntity
import com.example.data.local.mapper.movie.toModel
import com.example.data.local.roomdatabase.dao.MovieDao
import com.example.data.remote.api.MovieApi
import com.example.data.remote.mapper.moviepopular.toEntity
import com.example.data.remote.mapper.toModel
import com.example.domain.model.ModelResponseStatus
import com.example.domain.model.movie.ModelMovie
import com.example.domain.source.MovieDataSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import timber.log.Timber

class MovieRepository constructor(
    private val movieApi: MovieApi,
    private val movieDao: MovieDao,
) : MovieDataSource {

    companion object {
        private val TAG = MovieRepository::class.simpleName
    }

    override fun getDetail(id: Int): Observable<ModelMovie> {
        fetchMovieDetail(id)

        return movieDao.getMovieById(id)
            .logs("$TAG local getDetail id = $id")
            .map { it.toModel() }
    }

    fun fetchMovieDetail(id: Int) {
        movieApi.getDetail(id)
            .dataSchedulers()
            .logs("$TAG remote fetchMovieDetail id = $id")
            .map { it.toEntity() }
            .subscribe({ movieDao.insert(listOf(it)) },
                { error -> Timber.e("$TAG remote fetchMovieDetail id = $id ${error.message}") })
    }

    override fun getPopular(): Observable<List<ModelMovie>> {
        fetchPopularMovie()

        //TODO: Is there a cleaner way (expose observable source directly from DAO)
        //separate this function
        return movieDao.getPopularMovie()
            .logs("$TAG local getPopular ")
            .map { list -> list.map { it.toModel() } }
    }

    fun fetchPopularMovie() {
        movieApi.getPopular()
            .dataSchedulers()
            .logs("$TAG remote fetchPopularMovie")
            .map { it.results?.map { movie -> movie.toEntity() } ?: listOf() }
            .subscribe({ list -> movieDao.insert(list) },
                { error -> Timber.e("$TAG remote fetchPopularMovie ${error.message}") })
    }

    override fun rateMovie(id: Int, rate: Double): Single<ModelResponseStatus> {
        val paramsMap = hashMapOf<String, Any>()
        paramsMap["values"] = rate

        return movieApi.setRateMovie(id, paramsMap)
            .logs("$TAG rateMovie id =  $id rate = $rate")
            .map { it.toModel() }
    }
}
