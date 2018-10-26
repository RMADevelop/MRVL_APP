package com.mrvl.mrvl_app.core.di

import com.mrvl.mrvl_app.core.di.qualifier.IoThread
import com.mrvl.mrvl_app.core.di.qualifier.UiThread
import com.mrvl.mrvl_app.core.domain.IoRxScheduler
import com.mrvl.mrvl_app.core.domain.RxExecutionThread
import com.mrvl.mrvl_app.core.domain.UiRxScheduler
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ExecutorModule {

    @Provides
    @Singleton
    @IoThread
    fun provideIoThread(ioRxScheduler: IoRxScheduler): RxExecutionThread = ioRxScheduler

    @Provides
    @Singleton
    @UiThread
    fun provideUiThread(uiRxScheduler: UiRxScheduler): RxExecutionThread = uiRxScheduler
}