package com.example.domain.usecase.movie

import com.example.domain.model.movie.ModelMovie
import com.example.domain.source.MovieDataSource
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetPopularMoviesUseCaseTest {
    @Mock
    lateinit var movieDataSource: MovieDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `get popular movies success`() {
        val listMoviePopular = listOf(
            ModelMovie(id = 1, title = "Movie Test 1"),
            ModelMovie(id = 2, title = "Movie Test 2"),
            ModelMovie(id = 3, title = "Movie Test 3")
        )

        val getMoviePopularMoviesUseCase = GetPopularMoviesUseCase(movieDataSource)

        //given
        given(movieDataSource.getPopular()).willReturn(Observable.just(listMoviePopular))

        //when
        getMoviePopularMoviesUseCase().test().run {
            //then
            then(movieDataSource).should(times(1)).getPopular()
            assertValue(listMoviePopular)
        }
    }

    @Test
    fun `get popular movies failure`() {
        val error = Throwable("Network connection failed")
        val getMoviePopularMoviesUseCase = GetPopularMoviesUseCase(movieDataSource)

        //given
        given(movieDataSource.getPopular()).willReturn(Observable.error(error))

        //when
        getMoviePopularMoviesUseCase().test().run {
            //then
            then(movieDataSource).should(times(1)).getPopular()
            assertError(error)
            assertNotComplete()
        }
    }
}