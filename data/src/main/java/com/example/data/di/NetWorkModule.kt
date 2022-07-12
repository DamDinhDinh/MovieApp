package com.example.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.data.BuildConfig
import com.example.data.remote.api.MovieApi
import com.example.data.remote.api.ReviewApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetWorkModule {

    companion object {
        @JvmStatic
        private val TAG = NetWorkModule::class.java.simpleName

        private val READ_TIME_OUT = 30L
        private val READ_TIME_OUT_UNIT = TimeUnit.SECONDS
        private val CONNECT_TIME_OUT = 30L
        private val CONNECT_TIME_OUT_UNIT = TimeUnit.SECONDS
    }

    @Provides
    @Singleton
    fun provideHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor,
        @Named("auth") authInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(READ_TIME_OUT, READ_TIME_OUT_UNIT)
            .connectTimeout(CONNECT_TIME_OUT, CONNECT_TIME_OUT_UNIT)
            .addInterceptor(authInterceptor)
            .addInterceptor(chuckerInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    @Named("auth")
    fun provideAuthInterceptor(@Named("api-key") apiKey: String): Interceptor {
        return Interceptor { chain ->
            chain.request().newBuilder()
            val httpUrl: HttpUrl = chain.request().url.newBuilder()
                .addQueryParameter("api_key", apiKey)
                .addQueryParameter("session_id", "24917a217657dfdc18fee742ea17a40acbcefa2b")
                .build()

            val request: Request = chain.request().newBuilder()
                .url(httpUrl)
                .build()

            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideLogInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message -> Timber.tag(TAG).d(message) }
            .apply {
                setLevel(
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else
                        HttpLoggingInterceptor.Level.NONE
                )
            }
    }

    @Provides
    @Singleton
    fun provideChuckerInterceptor(@ApplicationContext context: Context) =
        ChuckerInterceptor.Builder(context).build()

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