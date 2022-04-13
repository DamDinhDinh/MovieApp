package com.example.movieapp.presenter.moviepopularlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.common.applySchedulers
import com.example.common.logs
import com.example.domain.usecase.movie.GetPopularMoviesUseCase
import com.example.movieapp.presenter.mapper.moviepopular.toPresent
import com.example.movieapp.presenter.model.moviepopular.MoviePopular
import javax.inject.Inject

class MoviePopularListViewModel @Inject constructor(val getPopularMoviesUseCase: GetPopularMoviesUseCase) :
    ViewModel(),
    MoviePopularListContract.ViewModel {

    companion object {
        private val TAG = MoviePopularListViewModel::class.simpleName
    }

    private val viewStateMutable = MutableLiveData<MoviePopularListContract.ViewState>()

    override fun fetchMoviePopular() {
        getPopularMoviesUseCase().applySchedulers()
            .map { list -> list.map { it.toPresent() } }
            .logs("$TAG fetchMoviePopular")
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

    class Factory :
        ViewModelProvider.Factory {
        private val getPopularMoviesUseCase: GetPopularMoviesUseCase

        @Inject
        constructor(getPopularMoviesUseCase: GetPopularMoviesUseCase) {
            this.getPopularMoviesUseCase = getPopularMoviesUseCase
        }

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(GetPopularMoviesUseCase::class.java)
                .newInstance(getPopularMoviesUseCase)
        }

    }
}