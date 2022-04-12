package com.example.common

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

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

//log
fun <T> Observable<T>.logs(tag: String = ""): Observable<T> = this
    .doOnNext { Timber.d("$tag event  = ${it ?: null}") }

fun <T> Single<T>.logs(tag: String = ""): Single<T> = this
    .doOnEvent { event, error -> Timber.d("$tag event = ${event ?: null}, error = ${error ?: null}") }

fun <T> Maybe<T>.logs(tag: String = ""): Maybe<T> = this
    .doOnEvent { event, error -> Timber.d("$tag event = ${event ?: null}, error = ${error ?: null}") }

fun Completable.logs(tag: String = ""): Completable = this
    .doOnEvent { Timber.d("$tag event  = ${it ?: null}") }

