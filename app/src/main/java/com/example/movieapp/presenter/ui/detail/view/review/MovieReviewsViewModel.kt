package com.example.movieapp.presenter.ui.detail.view.review

import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.movie.GetMovieReviewsUseCase
import com.example.movieapp.presenter.BaseViewModel
import com.example.movieapp.presenter.mapper.review.toPresent
import com.example.movieapp.presenter.model.review.Review
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieReviewsViewModel @Inject constructor(
    private val getMovieReviewsUseCase: GetMovieReviewsUseCase
) :
    BaseViewModel(),
    MovieReviewContract.ViewModel {

    companion object {
        private val TAG = MovieReviewsViewModel::class.simpleName
    }

    private val viewStateMutable = MutableStateFlow<MovieReviewContract.ViewState?>(null)

    override fun fetchReviews(id: String) {

        viewModelScope.launch {
            getMovieReviewsUseCase(GetMovieReviewsUseCase.Request(id))
                .flowOn(Dispatchers.IO)
                .catch { Timber.e(it) }
                .map { list -> list.map { it.toPresent() } }
                .collect { notifyViewState(it) }
        }
    }

    override fun observeViewState(): StateFlow<MovieReviewContract.ViewState?> = viewStateMutable.asStateFlow()

    private fun notifyViewState(reviews: List<Review>) {
        val newViewState = viewStateMutable.value?.copy(reviews = reviews)
            ?: MovieReviewContract.ViewState(reviews)
        viewStateMutable.value = newViewState
    }
}