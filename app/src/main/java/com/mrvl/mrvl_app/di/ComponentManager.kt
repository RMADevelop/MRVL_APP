package com.mrvl.mrvl_app.di

import android.app.Application
import android.support.annotation.IdRes
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.mrvl.mrvl_app.presentation.component.main.ui.AllHeroesFragment
import com.mrvl.mrvl_app.presentation.component.main.ui.AllHeroesPresenter

object ComponentManager {

    lateinit var appComponent: AppComponent
    lateinit var mainComponent: MainComponent

    fun injectApp(application: Application): AppComponent {
        appComponent = DaggerAppComponent.builder()
                .setApplication(application)
                .build()
        return appComponent


    }

    fun injectMain(fragmentManager: FragmentManager, fragmentActivity: FragmentActivity, @IdRes containerId: Int): MainComponent {
        mainComponent = appComponent.mainComponent()
                .setFragmentManager(fragmentManager)
                .setFragmentActivity(fragmentActivity)
                .setContainerId(containerId)
                .build()
        return mainComponent
    }

    fun inject(allHeroesFragment: AllHeroesFragment) {
        mainComponent.allHeroComponent().inject(allHeroesFragment)
    }
}