package com.example.domain.usecase.movie

import com.example.domain.model.movie.ModelMovie
import com.example.domain.source.MovieDataSource
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetMovieByIdUseCaseTest {
    @Mock
    lateinit var movieDataSource: MovieDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun getMovieByIdThenSuccess() {
        val movie = ModelMovie(id = 1, title = "Test Movie")

        val getMovieByIdUseCase = GetMovieByIdUseCase(movieDataSource)
        val request = GetMovieByIdUseCase.Request(1)

        //given
        given(movieDataSource.getDetail(anyInt()))
            .willReturn(Observable.just(movie))

        //when
        getMovieByIdUseCase(request).test().run {
            //then
            then(movieDataSource).should(times(1)).getDetail(1)
            assertValue { returnMovie -> returnMovie.id == movie.id }
        }
    }

    @Test
    fun getMovieByIdThenFailed() {
        val error = Throwable("Illegal Movie ID")

        val getMovieByIdUseCase = GetMovieByIdUseCase(movieDataSource)
        val request = GetMovieByIdUseCase.Request(-1)

        //given
        given(movieDataSource.getDetail(anyInt()))
            .willReturn(Observable.error(error))

        //when
        getMovieByIdUseCase(request).test().run {
            //then
            then(movieDataSource).should(times(1)).getDetail(request.id)
            assertError(error)
            assertNotComplete()
        }
    }
}