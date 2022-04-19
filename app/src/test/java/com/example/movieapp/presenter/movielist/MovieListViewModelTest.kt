package com.example.movieapp.presenter.movielist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.domain.model.movie.ModelMovie
import com.example.domain.usecase.movie.GetPopularMoviesUseCase
import com.example.movieapp.RxImmediateSchedulerRule
import com.example.movieapp.presenter.mapper.movie.toPresent
import com.example.movieapp.presenter.model.movie.Movie
import io.reactivex.rxjava3.core.Observable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


/**
 * Created by dinhdd damdinhdinh.mum@gmail.com on 4/18/2022.
 */
class MovieListViewModelTest {

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase

    lateinit var vm: MovieListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        vm = MovieListViewModel(getPopularMoviesUseCase)
    }

    @Test
    fun `fetch popular movie list success`() {
        //given
        val movies = listOf(
            ModelMovie(id = 1, title = "Movie Test 1"),
            ModelMovie(id = 2, title = "Movie Test 2"),
            ModelMovie(id = 3, title = "Movie Test 3")
        )
        given(getPopularMoviesUseCase()).willReturn(Observable.just(movies))

        //when
        vm.fetchMoviePopular()


        //then
//        var resultMovies: List<Movie>? = null
//        val latch = CountDownLatch(1)
//        val observer = object : Observer<MovieListContract.ViewState> {
//            override fun onChanged(viewstate: MovieListContract.ViewState?) {
//                resultMovies = viewstate?.movieList
//                latch.countDown()
//                vm.observeViewState().removeObserver(this)
//            }
//        }
//        vm.observeViewState().observeForever(observer)
//        latch.await(2, TimeUnit.SECONDS)

        //TODO: Do not use mapping here
        assertEquals(movies.map { it.toPresent() }, vm.observeViewState().value?.movieList)
    }

//    @Test
//    fun `fetch popular movie list failure`() {
//        //given
//        val error = Throwable("Cannot fetch popular movie")
//        given(getPopularMoviesUseCase()).willReturn(Observable.error(error))
//
//        //when
//        vm.fetchMoviePopular()
//
//        //then
//        var resultMovies = vm.observeViewState().getOrAwaitValueTest()
//
//        assertEquals(resultMovies, movies)
//    }
}
