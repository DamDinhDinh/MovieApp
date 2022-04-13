package com.example.data.di

import com.example.data.remote.api.MovieApi
import com.example.data.remote.api.ReviewApi
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class NetWorkModule {

    companion object {
        @Provides
        @Singleton
        fun getOKHttpClient(@Named("api-key") apiKey: String): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val httpUrl: HttpUrl = chain.request().url.newBuilder()
                        .addQueryParameter("api_key", apiKey)
                        .addQueryParameter("session_id", "24917a217657dfdc18fee742ea17a40acbcefa2b")
                        .build()

                    val request: Request = chain.request().newBuilder()
                        .url(httpUrl)
                        .build()

                    chain.proceed(request)
                }
//                .addInterceptor(loggingInterceptor) //log after chain
                .build()
        }

        @Provides
        @Singleton
        fun getRetrofit(@Named("base-url") baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }

        @Provides
        fun getMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

        @Provides
        fun getReviewApi(retrofit: Retrofit): ReviewApi = retrofit.create(ReviewApi::class.java)
    }

}