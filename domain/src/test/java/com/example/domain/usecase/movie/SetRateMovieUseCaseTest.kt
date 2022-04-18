package com.example.domain.usecase.movie

import com.example.domain.model.ModelResponseStatus
import com.example.domain.source.MovieDataSource
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SetRateMovieUseCaseTest {

    @Mock
    lateinit var movieDataSource: MovieDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `set rate movie success`() {
        val responseStatus = ModelResponseStatus(1, "OK")

        val setRateMovieUseCase = SetRateMovieUseCase(movieDataSource)
        val request = SetRateMovieUseCase.Request(1, 8.0)

        given(movieDataSource.rateMovie(request.id, request.rate)).willReturn(
            Single.just(
                responseStatus
            )
        )

        setRateMovieUseCase(request).test().run {
            then(movieDataSource).should(times(1)).rateMovie(request.id, request.rate)
            assertValue(responseStatus)
        }
    }

    @Test
    fun `set rate movie failure`() {
        val error = Throwable("Illegal Movie ID")

        val setRateMovieUseCase = SetRateMovieUseCase(movieDataSource)
        val request = SetRateMovieUseCase.Request(-1, 8.0)

        given(movieDataSource.rateMovie(request.id, request.rate)).willReturn(Single.error(error))

        setRateMovieUseCase(request).test().run {
            then(movieDataSource).should(times(1)).rateMovie(request.id, request.rate)
            assertError(error)
            assertNotComplete()
        }
    }
}