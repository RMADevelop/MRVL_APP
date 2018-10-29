package com.mrvl.mrvl_app.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.mrvl.mrvl_app.R
import com.mrvl.mrvl_app.core.presentation.view.BaseActivity
import com.mrvl.mrvl_app.di.ComponentManager
import com.mrvl.mrvl_app.presentation.component.splash.SplashListener
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView, SplashListener {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigator: Navigator

    @Inject
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter
    fun providePResenter() = mainPresenter


    override fun layoutId(): Int = R.layout.activity_main

    override fun inject() {
        ComponentManager.injectMain(supportFragmentManager, this, R.id.fragment_container).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            initBottomNavigation()
        }
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun showPlaceHolder() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initBottomNavigation() {
        bottom_navigation_view.visibility = View.GONE
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.all_hero_menu_item -> mainPresenter.goToAllHero()
                R.id.favourite_menu_item -> mainPresenter.goToFavourite()
            }
            true
        }
    }

    override fun splashShowed() {
        Log.d("ldsfsd","showed")
        bottom_navigation_view.visibility = View.VISIBLE
    }
}
