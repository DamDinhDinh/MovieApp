package com.example.movieapp.data.repo

import com.example.data.api.MovieApi
import com.example.data.jsonmodel.movie.JsonMovie
import com.example.data.repo.MovieRepository
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import uk.co.jemos.podam.api.PodamFactoryImpl

class MovieRepositoryTest {

    @Mock
    lateinit var movieApi: MovieApi

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun getMovieByIdThenSuccess() {
        val podamFactory = PodamFactoryImpl()
        val givenMovie = podamFactory.manufacturePojo(JsonMovie::class.java).copy(id = 1)

        val movieRepository = MovieRepository(movieApi)

        //given
        given(movieApi.getDetail(1)).willReturn(Single.just(givenMovie))

        //when
        movieRepository.getDetail(1).test().run {

            //then
            then(movieApi).should(times(1)).getDetail(1)
            assertValue { movieReturn -> movieReturn.id == givenMovie.id }
        }

    }
}