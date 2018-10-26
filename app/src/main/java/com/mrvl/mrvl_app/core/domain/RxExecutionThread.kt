package com.mrvl.mrvl_app.core.domain

import io.reactivex.Scheduler

interface RxExecutionThread {

    fun getScheduler(): Scheduler
}