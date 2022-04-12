package com.example.data.di

import com.example.data.BuildConfig
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

        @Provides
        @Named("base-img-url")
        fun getBaseImgUrl(): String {
            return BuildConfig.BASE_IMG_URL
        }
    }

}