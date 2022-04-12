package com.example.movieapp.domain.usecase

import com.example.movieapp.domain.source.MovieDataSource
import com.example.movieapp.domain.model.movie.ModelMovie
import com.example.movieapp.domain.usecase.movie.GetMovieByIdUseCase
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import uk.co.jemos.podam.api.PodamFactoryImpl

class GetMovieByIdUseCaseTest {
    @Mock
    lateinit var movieDataSource: MovieDataSource

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun getMovieByIdThenSuccess() {
        val podamFactory = PodamFactoryImpl()
        val givenMovie = podamFactory.manufacturePojo(ModelMovie::class.java).copy(id = 1)

        val getMovieByIdUseCase = GetMovieByIdUseCase(movieDataSource)
        val request = GetMovieByIdUseCase.Request(1)

        //given
        given(movieDataSource.getDetail(anyInt())).willReturn(Single.just(givenMovie))

        //when
        getMovieByIdUseCase(request).test().run {
            //then
            then(movieDataSource).should(times(1)).getDetail(1)
            assertValue { returnMovie -> returnMovie.id == givenMovie.id }
        }
    }
}