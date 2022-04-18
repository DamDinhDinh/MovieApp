package com.example.movieapp.presenter

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()

        if (!disposables.isDisposed) disposables.dispose()
    }

    fun Disposable.addDisposable(vm: BaseViewModel) {
        disposables.add(this)
    }
}