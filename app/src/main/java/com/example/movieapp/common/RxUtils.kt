package com.example.movieapp.common

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RxUtils

fun <T> Observable<T>.applySchedulers(): Observable<T> = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.applySchedulers(): Single<T> = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun <T> Maybe<T>.applySchedulers(): Maybe<T> = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun Completable.applySchedulers(): Completable = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
