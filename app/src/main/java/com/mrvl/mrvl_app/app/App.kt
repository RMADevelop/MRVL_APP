package com.mrvl.mrvl_app.app

import android.app.Application
import com.mrvl.mrvl_app.di.AppComponent
import com.mrvl.mrvl_app.di.ComponentManager

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = ComponentManager.injectApp(this)
        appComponent.inject(this)
    }
}