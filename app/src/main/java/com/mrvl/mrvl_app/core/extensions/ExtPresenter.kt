package com.mrvl.mrvl_app.core.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.connect(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}