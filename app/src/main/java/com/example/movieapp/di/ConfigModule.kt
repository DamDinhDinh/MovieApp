package com.example.movieapp.di

import com.example.movieapp.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class ConfigModule {

    companion object {
        @Provides
        @Named("api-key")
        fun getApiKey(): String {
            return BuildConfig.API_KEY
        }

        @Provides
        @Named("base-url")
        fun getBaseUrl(): String {
            return BuildConfig.BASE_URL
        }
    }

}