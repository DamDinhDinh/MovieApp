package com.example.data.di

import com.example.data.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module

val configModule = module {
    single(named("api-key"), createdAtStart = true) { BuildConfig.API_KEY }
    single(named("base-url"), createdAtStart = true) { BuildConfig.BASE_URL }
    single(named("base-img-url"), createdAtStart = true) { BuildConfig.BASE_IMG_URL }
}