package com.mrvl.mrvl_app.presentation.core

import android.content.Context
import android.content.Intent
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.mrvl.mrvl_app.app.AppScreens
import com.mrvl.mrvl_app.presentation.component.main.ui.AllHeroesFragment
import com.mrvl.mrvl_app.presentation.component.splash.SplashFragment
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

class MainNavigator @Inject constructor(
        private val fragmentActivity: FragmentActivity,
        private val frgamentManager: FragmentManager,
        @IdRes val containerId: Int
) : SupportAppNavigator(fragmentActivity, frgamentManager, containerId) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? {
        return null
    }

    override fun createFragment(screenKey: String?, data: Any?): Fragment {
        return when (screenKey) {
            AppScreens.SPLASH_SCREEN -> SplashFragment.newInstance()
            AppScreens.MAIN_SCREEN_KEY -> AllHeroesFragment.newInstance()
            AppScreens.ALL_HERO_SCREEN_KEY -> AllHeroesFragment.newInstance()
            else -> throw IllegalArgumentException("Fragment not founded $screenKey")
        }
    }
}