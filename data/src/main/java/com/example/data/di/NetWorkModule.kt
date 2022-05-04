package com.example.data.di

import com.example.data.BuildConfig
import com.example.data.remote.api.MovieApi
import com.example.data.remote.api.ReviewApi
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val netWorkModule = module {
    single { getOKHttpClient(get(named("api-key"))) }
    single { getRetrofit(get(named("base-url")), get()) }
    factory { (retrofit: Retrofit) -> retrofit.create(MovieApi::class.java) } bind MovieApi::class
    factory { (retrofit: Retrofit) -> retrofit.create(ReviewApi::class.java) } bind ReviewApi::class
}

fun getOKHttpClient(apiKey: String): OkHttpClient {
    if (BuildConfig.DEBUG) {
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
            .addInterceptor(loggingInterceptor) //log after chain
            .build()
    } else {
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
            .build()
    }
}

fun getRetrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
}