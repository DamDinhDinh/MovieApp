package com.example.movieapp.presenter.ui.detail

import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.movie.GetMovieByIdUseCase
import com.example.movieapp.presenter.BaseViewModel
import com.example.movieapp.presenter.mapper.movie.toPresent
import com.example.movieapp.presenter.model.movie.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieByIdUseCase: GetMovieByIdUseCase
) :
    BaseViewModel(),
    MovieDetailContract.ViewModel {

    companion object {
        private val TAG = "CoroutineMovieDetailViewModel"
    }

    private val viewStateMutable = MutableStateFlow<MovieDetailContract.ViewState?>(null)

    override fun fetchMovie(id: String) {
        viewModelScope.launch {
            getMovieByIdUseCase(GetMovieByIdUseCase.Request(id))
                .flowOn(Dispatchers.IO)
                .catch { Timber.tag(TAG).e(it) }
                .map { it.toPresent() }
                .collect { notifyViewState(it) }
        }
    }

    override fun observeViewState(): StateFlow<MovieDetailContract.ViewState?> = viewStateMutable.asStateFlow()

    private fun notifyViewState(movie: Movie) {
        val newViewState = viewStateMutable.value?.copy(movie = movie)
            ?: MovieDetailContract.ViewState(movie)
        viewStateMutable.value = newViewState
    }
}