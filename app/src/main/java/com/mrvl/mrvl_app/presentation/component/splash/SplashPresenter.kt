package com.mrvl.mrvl_app.presentation.component.splash

import com.arellomobile.mvp.InjectViewState
import com.mrvl.mrvl_app.app.AppScreens
import com.mrvl.mrvl_app.presentation.core.mvp.presenter.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SplashPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<SplashView>() {

    fun splashShowed() =
            router.replaceScreen(AppScreens.MAIN_SCREEN_KEY)
}