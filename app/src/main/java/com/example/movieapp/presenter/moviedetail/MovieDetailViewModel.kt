package com.example.movieapp.presenter.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.common.applySchedulers
import com.example.movieapp.domain.source.MovieDataSource
import com.example.movieapp.presenter.mapper.movie.toPresent
import com.example.movieapp.presenter.model.movie.Movie
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val moveDataSource: MovieDataSource) :
    ViewModel(),
    MovieDetailContract.ViewModel {

    private val TAG = "MovieDetailViewModel"

    private val viewStateMutable = MutableLiveData<MovieDetailContract.ViewState>()

    override fun fetchMovie(id: Int) {
        moveDataSource.getDetail(id).applySchedulers()
            .map { it.toPresent() }.doOnEvent { list, error ->
                println("$TAG fetchMovie $list")
                println("$TAG fetchMovie $error")
            }
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
}