package com.example.movieapp.presenter.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.common.applySchedulers
import com.example.common.logs
import com.example.domain.source.MovieDataSource
import com.example.movieapp.presenter.mapper.movie.toPresent
import com.example.movieapp.presenter.model.movie.Movie
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val movieDataSource: MovieDataSource) :
    ViewModel(),
    MovieDetailContract.ViewModel {

    companion object {
        private val TAG = MovieDetailViewModel::class.simpleName
    }

    private val viewStateMutable = MutableLiveData<MovieDetailContract.ViewState>()

    override fun fetchMovie(id: Int) {
        movieDataSource.getDetail(id).applySchedulers()
            .map { it.toPresent() }
            .logs("$TAG fetchMovie")
            .subscribe({ movie -> notifyViewState(movie) }, { error -> error.printStackTrace() })
    }

    override fun observeViewState(): LiveData<MovieDetailContract.ViewState> {
        return viewStateMutable
    }

    private fun notifyViewState(movie: Movie) {
        val newViewState = viewStateMutable.value?.copy(movie = movie)
            ?: MovieDetailContract.ViewState(movie)
        viewStateMutable.value = newViewState
    }

    class Factory : ViewModelProvider.Factory {
        val movieDataSource: MovieDataSource

        @Inject
        constructor(moveDataSource: MovieDataSource) {
            this.movieDataSource = moveDataSource
        }

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(MovieDataSource::class.java)
                .newInstance(movieDataSource)
        }

    }
}