package com.example.movieapp.presenter.movielist

import com.example.common.applySchedulers
import com.example.common.dataSchedulers
import com.example.data.local.mapper.movie.toModel
import com.example.data.local.roomdatabase.dao.MovieDao
import com.example.data.remote.api.MovieApi
import com.example.data.remote.mapper.moviepopular.toEntity
import com.example.domain.model.movie.ModelMovie
import com.example.movieapp.presenter.mapper.movie.toPresent
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class MovieListPresenter @Inject constructor(private val movieApi: MovieApi, private val movieDao: MovieDao) :
    MovieListContract.Presenter {

    private lateinit var view: MovieListContract.View
    private var getMoviePopularDisposable: Disposable? = null

    override fun fetchMoviePopular() {
        getMoviePopularDisposable?.let { if (!it.isDisposed) it.dispose() }
        getMoviePopularDisposable =
            getPopular().applySchedulers()
                .map { list -> list.map { it.toPresent() } }
                .subscribe(
                    { list ->
                        view.updateList(list)
                    }, { error -> error.printStackTrace() }
                )
    }

    override fun setView(view: MovieListContract.View) {
        this.view = view
    }

    private fun getPopular(): Observable<List<ModelMovie>> {
        fetchAndSavePopularMovie()
        return movieDao.getPopularMovie()
            .map { list -> list.map { it.toModel() } }
    }

    private fun fetchAndSavePopularMovie() {
        movieApi.getPopular()
            .dataSchedulers()
            .map { it.results?.map { movie -> movie.toEntity() } ?: listOf() }
            .subscribe({ list -> movieDao.insert(list) },
                { error -> error.printStackTrace() })
    }

    override fun destroy() {
        getMoviePopularDisposable?.let {
            if (!it.isDisposed) it.dispose()
        }
    }
}