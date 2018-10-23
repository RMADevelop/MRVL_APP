package com.mrvl.mrvl_app.di

import com.mrvl.mrvl_app.core.di.scopes.FragmentScope
import com.mrvl.mrvl_app.data.allHero.AllHeroDataRepository
import com.mrvl.mrvl_app.data.allHero.AllHeroDataService
import com.mrvl.mrvl_app.data.allHero.AllHeroRepository
import com.mrvl.mrvl_app.data.allHero.AllHeroService
import com.mrvl.mrvl_app.domain.allHero.AllHeroDomainInteractor
import com.mrvl.mrvl_app.domain.allHero.AllHeroInteractor
import com.mrvl.mrvl_app.presentation.component.main.ui.AllHeroesFragment
import com.mrvl.mrvl_app.presentation.component.main.ui.AllHeroesPresenter
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [
    AllHeroModule::class
])
interface AllHeroComponent {

    fun inject(allHeroesFragment: AllHeroesFragment)

    fun presenter(): AllHeroesPresenter
}

@Module
class AllHeroModule {

    @Provides
    @FragmentScope
    fun provideInteractor(interactor: AllHeroDomainInteractor): AllHeroInteractor = interactor

    @Provides
    @FragmentScope
    fun provideRepository(allHeroDataRepository: AllHeroDataRepository): AllHeroRepository = allHeroDataRepository

    @Provides
    @FragmentScope
    fun provideService(allHeroDataService: AllHeroDataService): AllHeroService = allHeroDataService
}