package com.mrvl.mrvl_app.di

import com.mrvl.mrvl_app.core.di.scopes.FragmentScope
import com.mrvl.mrvl_app.presentation.component.splash.SplashPresenter
import dagger.Module
import dagger.Subcomponent


@FragmentScope
@Subcomponent(modules = [SplashModule::class])
interface SplashComponent {

    fun presenter(): SplashPresenter
}

@Module
class SplashModule