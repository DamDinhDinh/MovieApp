package com.example.movieapp.presenter.ui.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.movie.GetPopularMoviesUseCase
import com.example.movieapp.presenter.BaseViewModel
import com.example.movieapp.presenter.common.utils.SingleLiveEvent
import com.example.movieapp.presenter.mapper.movie.toPresent
import com.example.movieapp.presenter.model.movie.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(val getPopularMoviesUseCase: GetPopularMoviesUseCase) :
    BaseViewModel(),
    MovieListContract.ViewModel {

    companion object {
        private const val TAG = "CoroutineMovieListViewModel"
    }

    private val viewStateMutable = MutableLiveData<MovieListContract.ViewState>()
    private val navigateEvent: SingleLiveEvent<MovieListContract.NavigateEvent> = SingleLiveEvent()


    override fun fetchMoviePopular() {
        viewModelScope.launch {
            getPopularMoviesUseCase()
                .onEach { Timber.d("fetchMoviePopular") }
                .flowOn(Dispatchers.IO)
                .catch { Timber.e(it) }
                .map { list -> list.map { it.toPresent() } }
                .onEach { Timber.d("fetchMoviePopular result $it") }
                .collect { notifyViewState(it) }
        }
    }

    override fun observeViewState(): LiveData<MovieListContract.ViewState> {
        return viewStateMutable
    }

    override fun observeNavigate(): SingleLiveEvent<MovieListContract.NavigateEvent> {
        return navigateEvent
    }

    override fun onMovieClick(movie: Movie) {
        navigateEvent.value = MovieListContract.NavigateEvent.NavigateMovieDetail(movie)
    }

    private fun notifyViewState(movieList: List<Movie>) {
        val newViewState = viewStateMutable.value?.copy(movieList = movieList)
            ?: MovieListContract.ViewState(movieList)
        viewStateMutable.value = newViewState
    }
}
