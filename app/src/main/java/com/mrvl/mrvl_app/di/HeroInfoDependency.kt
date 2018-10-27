package com.mrvl.mrvl_app.di

import com.mrvl.mrvl_app.core.di.scopes.FragmentScope
import com.mrvl.mrvl_app.presentation.component.heroInfo.ui.HeroInfoFragment
import com.mrvl.mrvl_app.presentation.component.heroInfo.ui.HeroInfoPresenter
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [HeroInfoModule::class])
interface HeroInfoComponent {

    fun inject(heroInfoFragment: HeroInfoFragment)

    fun providePresenter(): HeroInfoPresenter
}

@Module

class HeroInfoModule() {


}