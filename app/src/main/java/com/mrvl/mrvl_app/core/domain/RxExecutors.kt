package com.mrvl.mrvl_app.core.domain

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class IoRxScheduler @Inject constructor() : RxExecutionThread {
    override fun getScheduler(): Scheduler = Schedulers.io()
}

class UiRxScheduler @Inject constructor() : RxExecutionThread {
    override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()
}