package com.mrvl.mrvl_app.presentation.component.main.ui

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.mrvl.mrvl_app.core.di.qualifier.IoThread
import com.mrvl.mrvl_app.core.di.qualifier.UiThread
import com.mrvl.mrvl_app.core.domain.Mapper
import com.mrvl.mrvl_app.core.domain.RxExecutionThread
import com.mrvl.mrvl_app.domain.allHero.AllHeroInteractor
import com.mrvl.mrvl_app.domain.allHero.DataDomain
import com.mrvl.mrvl_app.presentation.component.main.model.DataPresentation
import com.mrvl.mrvl_app.presentation.core.mvp.presenter.BasePresenter
import javax.inject.Inject

@InjectViewState
class AllHeroesPresenter @Inject constructor(
        private val allHeroInteractor: AllHeroInteractor,
        @IoThread val ioScheduler: RxExecutionThread,
        @UiThread val uiScheduler: RxExecutionThread,
        private var heroMapper: Mapper<DataDomain, DataPresentation>
) : BasePresenter<AllHeroesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadMore()
    }

    fun loadMore() {
        Log.d("iokhjnb", "sddfdjsfg")
        allHeroInteractor.getAllHero()
                .map {
                    heroMapper.transform(it.dataRemote)
                            .result
                }
                .subscribeOn(ioScheduler.getScheduler())
                .observeOn(uiScheduler.getScheduler())
                .subscribe({
                    viewState.showHeroes(it)
                }, {
                    viewState.loadError()
                    it.printStackTrace()
                })
    }
}