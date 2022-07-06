package com.example.movieapp.presenter.ui.detail.view.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.common.applySchedulers
import com.example.common.logs
import com.example.domain.usecase.movie.GetMovieReviewsUseCase
import com.example.movieapp.presenter.BaseViewModel
import com.example.movieapp.presenter.mapper.review.toPresent
import com.example.movieapp.presenter.model.review.Review
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.Disposable
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
    private var getReviewDisposable: Disposable? = null

    override fun fetchReviews(id: Int) {
        getReviewDisposable?.let { if (!it.isDisposed) it.dispose() }
        getReviewDisposable =
            getMovieReviewsUseCase(GetMovieReviewsUseCase.Request(id)).applySchedulers()
                .map { list -> list.map { it.toPresent() } }
                .logs("$TAG fetchReviews")
                .subscribe({ list -> notifyViewState(list) }, { error -> error.printStackTrace() })

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