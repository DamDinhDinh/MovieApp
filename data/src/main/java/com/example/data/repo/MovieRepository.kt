package com.example.data.repo

import com.example.common.dataSchedulers
import com.example.common.logs
import com.example.data.local.databasemodel.roomdatabase.dao.MovieDao
import com.example.data.mapper.movie.toEntity
import com.example.data.mapper.movie.toModel
import com.example.data.remote.api.MovieApi
import com.example.data.remote.mapper.moviepopular.toEntity
import com.example.data.remote.mapper.toModel
import com.example.domain.model.ModelResponseStatus
import com.example.domain.model.movie.ModelMovie
import com.example.domain.source.MovieDataSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import timber.log.Timber
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDao: MovieDao,
) : MovieDataSource {

    companion object {
        private val TAG = MovieRepository::class.simpleName
    }

    override fun getDetail(id: Int): Observable<ModelMovie> {
        movieApi.getDetail(id)
            .dataSchedulers()
            .logs("$TAG remote getDetail id = $id")
            .map { it.toEntity() }
            .subscribe({ movieDao.insert(listOf(it)) },
                { error -> Timber.e("$TAG remote getDetail id = $id ${error.message}") })

        return movieDao.getMovieById(id)
            .logs("$TAG local getDetail id = $id")
            .map { it.toModel() }
    }

    override fun getPopular(): Observable<List<ModelMovie>> {
        movieApi.getPopular()
            .dataSchedulers()
            .logs("$TAG remote getPopular")
            .map { response ->
                if (!response.results.isNullOrEmpty()) response.results.map { it.toEntity() } else listOf()
            }
            .subscribe({ list -> movieDao.insert(list) },
                { error -> Timber.e("$TAG remote getPopular ${error.message}") })

        return movieDao.getPopularMovie().logs("$TAG local getPopular ")
            .map { list -> list.map { it.toModel() } }
    }

    override fun rateMovie(id: Int, rate: Double): Single<ModelResponseStatus> {
        val paramsMap = hashMapOf<String, Any>()
        paramsMap["values"] = rate
        return movieApi.setRateMovie(id, paramsMap)
            .logs("$TAG rateMovie id =  $id rate = $rate")
            .map { it.toModel() }
    }
}
