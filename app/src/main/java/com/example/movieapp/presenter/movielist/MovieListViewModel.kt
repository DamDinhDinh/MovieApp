//package com.example.movieapp.presenter.movielist
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.example.common.applySchedulers
//import com.example.common.logs
//import com.example.domain.usecase.movie.GetPopularMoviesUseCase
//import com.example.movieapp.presenter.BaseViewModel
//import com.example.movieapp.presenter.mapper.movie.toPresent
//import com.example.movieapp.presenter.model.movie.Movie
//import dagger.hilt.android.lifecycle.HiltViewModel
//import io.reactivex.rxjava3.disposables.Disposable
//import javax.inject.Inject
//
//@HiltViewModel
//class MovieListViewModel @Inject constructor(val getPopularMoviesUseCase: GetPopularMoviesUseCase) :
//    BaseViewModel(),
//    MovieListContract.ViewModel {
//
//    companion object {
//        private val TAG = MovieListViewModel::class.simpleName
//    }
//
//    private val viewStateMutable = MutableLiveData<MovieListContract.ViewState>()
//    private var getMoviePopularDisposable: Disposable? = null
//
//    override fun fetchMoviePopular() {
//        getMoviePopularDisposable?.let { if (!it.isDisposed) it.dispose() }
//        getMoviePopularDisposable =
//            getPopularMoviesUseCase().applySchedulers()
//                .map { list -> list.map { it.toPresent() } }
//                .logs("$TAG fetchMoviePopular")
//                .subscribe({ list -> notifyViewState(list) }, { error -> error.printStackTrace() })
//                .apply {
//                    addDisposable(this@MovieListViewModel)
//                }
//    }
//
//    override fun observeViewState(): LiveData<MovieListContract.ViewState> {
//        return viewStateMutable
//    }
//
//    private fun notifyViewState(movieList: List<Movie>) {
//        val newViewState = viewStateMutable.value?.copy(movieList = movieList)
//            ?: MovieListContract.ViewState(movieList)
//        viewStateMutable.value = newViewState
//    }
//}
