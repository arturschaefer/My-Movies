package com.schaefer.mymovies.core.viewmodel

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class DisposableViewModel : androidx.lifecycle.ViewModel() {

    private val disposable = CompositeDisposable()

    protected fun Disposable.handleDisposable(): Disposable =
        apply { disposable.add(this) }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}