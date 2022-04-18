package com.example.domain.usecase.movie

import com.example.domain.model.review.ModelReview
import com.example.domain.source.ReviewDataSource
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetMovieReviewsUseCaseTest {
    @Mock
    lateinit var reviewDataSource: ReviewDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `get movie reviews success`() {
        val listReview = listOf(
            ModelReview(id = "1", author = "Author 1"),
            ModelReview(id = "2", author = "Author 2"),
            ModelReview(id = "3", author = "Author 3")
        )

        val getMovieReviewsUseCase = GetMovieReviewsUseCase(reviewDataSource)
        val request = GetMovieReviewsUseCase.Request(1)

        //given
        given(reviewDataSource.getReviewsOfMovie(anyInt())).willReturn(Observable.just(listReview))

        //when
        getMovieReviewsUseCase(request).test().run {
            //then
            then(reviewDataSource).should(times(1)).getReviewsOfMovie(request.id)
            assertValue(listReview)
        }
    }

    @Test
    fun `get movie reviews failure`() {
        val error = Throwable("Illegal Movie ID")

        val getMovieReviewsUseCase = GetMovieReviewsUseCase(reviewDataSource)
        val request = GetMovieReviewsUseCase.Request(-1)

        //given
        given(reviewDataSource.getReviewsOfMovie(request.id)).willReturn(Observable.error(error))

        //when
        getMovieReviewsUseCase(request).test().run {
            //then
            then(reviewDataSource).should(times(1)).getReviewsOfMovie(request.id)
            assertError(error)
            assertNotComplete()
        }
    }
}