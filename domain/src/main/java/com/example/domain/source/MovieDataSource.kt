package com.example.domain.source

import com.example.domain.model.ModelResponseStatus
import com.example.domain.model.movie.ModelMovie
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface MovieDataSource {

    fun getDetail(id: Int): Observable<ModelMovie>

    fun getPopular(): Observable<List<ModelMovie>>

    fun rateMovie(id: Int, rate: Double): Single<ModelResponseStatus>
}