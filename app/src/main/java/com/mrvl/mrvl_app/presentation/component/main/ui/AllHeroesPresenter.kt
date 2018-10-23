package com.mrvl.mrvl_app.presentation.component.main.ui

import com.arellomobile.mvp.InjectViewState
import com.mrvl.mrvl_app.domain.allHero.AllHeroInteractor
import com.mrvl.mrvl_app.presentation.core.mvp.presenter.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class AllHeroesPresenter @Inject constructor(
        private val allHeroInteractor: AllHeroInteractor
) : BasePresenter<AllHeroesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        allHeroInteractor.getAllHero()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }
}