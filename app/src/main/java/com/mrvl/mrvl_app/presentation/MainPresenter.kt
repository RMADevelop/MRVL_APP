package com.mrvl.mrvl_app.presentation

import com.mrvl.mrvl_app.app.AppScreens
import com.mrvl.mrvl_app.presentation.core.mvp.presenter.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.navigateTo(AppScreens.MAIN_SCREEN_KEY)
    }

    fun goToAllHero() =
            router.navigateTo(AppScreens.ALL_HERO_SCREEN_KEY)

    fun goToFavourite() =
            router.navigateTo(AppScreens.FAVOURITES_SCREEN_KEY)
}