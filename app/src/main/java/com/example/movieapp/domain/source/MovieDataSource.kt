package com.example.movieapp.domain.source

import com.example.movieapp.domain.model.ModelResponseStatus
import com.example.movieapp.domain.model.movie.ModelMovie
import com.example.movieapp.domain.model.moviepopular.ModelMoviePopular
import io.reactivex.rxjava3.core.Single

interface MovieDataSource {

    fun getDetail(id: Int): Single<ModelMovie>

    fun getPopular(): Single<List<ModelMoviePopular>>

    fun rateMovie(id: Int, rate: Double): Single<ModelResponseStatus>
}