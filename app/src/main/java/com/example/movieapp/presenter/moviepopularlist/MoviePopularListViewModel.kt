package com.example.movieapp.presenter.moviepopularlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.common.applySchedulers
import com.example.movieapp.domain.usecase.movie.GetMoviesPopularUserCase
import com.example.movieapp.presenter.mapper.moviepopular.toPresent
import com.example.movieapp.presenter.model.moviepopular.MoviePopular
import javax.inject.Inject

class MoviePopularListViewModel @Inject constructor(val getMoviesPopularUserCase: GetMoviesPopularUserCase) :
    ViewModel(),
    MoviePopularListContract.ViewModel {

    private val TAG = "MoviePopularListViewModel"

    private val viewStateMutable = MutableLiveData<MoviePopularListContract.ViewState>()

    override fun fetchMoviePopular() {
        getMoviesPopularUserCase().applySchedulers()
            .map { list -> list.map { it.toPresent() } }
            .doOnEvent { list, error ->
                println("$TAG fetchMoviePopular $list")
                println("$TAG fetchMoviePopular $error")
            }
            .subscribe({ list -> notifyViewState(list) }, { error -> error.printStackTrace() })
    }

    override fun observeViewState(): LiveData<MoviePopularListContract.ViewState> {
        return viewStateMutable
    }

    private fun notifyViewState(movieList: List<MoviePopular>) {
        val newViewState = viewStateMutable.value?.copy(movieList = movieList)
            ?: MoviePopularListContract.ViewState(movieList)
        viewStateMutable.value = newViewState
    }
}