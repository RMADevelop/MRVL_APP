package com.mrvl.mrvl_app.di

import android.support.annotation.IdRes
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.mrvl.mrvl_app.core.di.scopes.ActivityScope
import com.mrvl.mrvl_app.presentation.MainActivity
import com.mrvl.mrvl_app.presentation.core.MainNavigator
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.terrakok.cicerone.Navigator


@ActivityScope
@Subcomponent(modules = [
    MainModule::class])
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun allHeroComponent(): AllHeroComponent

    fun heroInfoComponent(): HeroInfoComponent

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun setFragmentManager(fragmentManager: FragmentManager): Builder

        @BindsInstance
        fun setFragmentActivity(fragmentActivity: FragmentActivity): Builder

        @BindsInstance
        fun setContainerId(@IdRes containerId: Int): Builder

        fun build(): MainComponent
    }

}

@Module
class MainModule {

    @ActivityScope
    @Provides
    fun provideNavigator(mainNavigator: MainNavigator): Navigator = mainNavigator
}