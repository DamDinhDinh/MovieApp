package com.example.movieapp.presenter.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.movie.GetMovieByIdUseCase
import com.example.movieapp.presenter.BaseViewModel
import com.example.movieapp.presenter.mapper.movie.toPresent
import com.example.movieapp.presenter.model.movie.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
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

    private val viewStateMutable = MutableLiveData<MovieDetailContract.ViewState>()

    override fun fetchMovie(id: Int) {
        viewModelScope.launch {
            getMovieByIdUseCase(GetMovieByIdUseCase.Request(id))
                .flowOn(Dispatchers.IO)
                .catch { Timber.tag(TAG).e(it) }
                .map { it.toPresent() }
                .collect { notifyViewState(it) }
        }
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