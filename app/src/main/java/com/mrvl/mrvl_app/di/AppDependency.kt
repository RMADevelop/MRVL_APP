package com.mrvl.mrvl_app.di

import android.app.Application
import android.content.Context
import com.mrvl.mrvl_app.app.App
import com.mrvl.mrvl_app.core.di.ExecutorModule
import com.mrvl.mrvl_app.core.di.NavigationModule
import com.mrvl.mrvl_app.core.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    NavigationModule::class,
    ExecutorModule::class,
    AppModule::class
])
interface AppComponent {

    fun inject(app: App)

    fun mainComponent(): MainComponent.Builder

    @Component.Builder

    interface Builder {
        @BindsInstance
        fun setApplication(application: Application): Builder

        fun build(): AppComponent
    }
}

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.baseContext
}