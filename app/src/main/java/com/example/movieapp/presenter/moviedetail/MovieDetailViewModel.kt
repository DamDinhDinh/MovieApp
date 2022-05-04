package com.example.movieapp.presenter.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.common.applySchedulers
import com.example.common.logs
import com.example.domain.usecase.movie.GetMovieByIdUseCase
import com.example.movieapp.presenter.BaseViewModel
import com.example.movieapp.presenter.mapper.movie.toPresent
import com.example.movieapp.presenter.model.movie.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieByIdUseCase: GetMovieByIdUseCase
) :
    BaseViewModel(),
    MovieDetailContract.ViewModel {

    companion object {
        private val TAG = MovieDetailViewModel::class.simpleName
    }

    private val viewStateMutable = MutableLiveData<MovieDetailContract.ViewState>()
    private var getMovieDisposable: Disposable? = null

    override fun fetchMovie(id: Int) {
        getMovieDisposable?.let { if (!it.isDisposed) it.dispose() }
        getMovieDisposable =
            getMovieByIdUseCase(GetMovieByIdUseCase.Request(id))
                .applySchedulers()
                .map { it.toPresent() }
                .logs("$TAG fetchMovie")
                .subscribe(
                    { movie -> notifyViewState(movie) },
                    { error -> error.printStackTrace() })

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