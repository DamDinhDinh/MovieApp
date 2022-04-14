package com.example.movieapp.data.repo

import com.example.data.local.roomdatabase.dao.MovieDao
import com.example.data.remote.api.MovieApi
import com.example.data.remote.jsonmodel.movie.JsonMovie
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

    @Mock
    lateinit var movieDao: MovieDao

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun getMovieByIdThenSuccess() {
        val podamFactory = PodamFactoryImpl()
        val givenMovie = podamFactory.manufacturePojo(JsonMovie::class.java).copy(id = 1)

        val movieRepository = MovieRepository(movieApi, movieDao)

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