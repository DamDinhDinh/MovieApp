package com.example.domain.source

import com.example.domain.model.ModelResponseStatus
import com.example.domain.model.movie.ModelMovie
import kotlinx.coroutines.flow.Flow

interface MovieDataSource {

    suspend fun getDetail(id: String): Flow<ModelMovie>

    suspend fun getPopular(): Flow<List<ModelMovie>>

    suspend fun rateMovie(id: String, rate: Double): Flow<ModelResponseStatus>
}