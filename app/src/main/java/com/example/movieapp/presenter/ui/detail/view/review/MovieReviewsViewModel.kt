package com.example.movieapp.presenter.ui.detail.view.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.movie.GetMovieReviewsUseCase
import com.example.movieapp.presenter.BaseViewModel
import com.example.movieapp.presenter.mapper.review.toPresent
import com.example.movieapp.presenter.model.review.Review
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
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

    private val viewStateMutable = MutableLiveData<MovieReviewContract.ViewState>()

    override fun fetchReviews(id: Int) {
        viewModelScope.launch {
            getMovieReviewsUseCase(GetMovieReviewsUseCase.Request(id))
                .flowOn(Dispatchers.IO)
                .catch { Timber.e(it) }
                .map { list -> list.map { it.toPresent() } }
                .collect { notifyViewState(it) }
        }
    }

    override fun observeViewState(): LiveData<MovieReviewContract.ViewState> {
        return viewStateMutable
    }

    private fun notifyViewState(reviews: List<Review>) {
        val newViewState = viewStateMutable.value?.copy(reviews = reviews)
            ?: MovieReviewContract.ViewState(reviews)
        viewStateMutable.value = newViewState
    }
}