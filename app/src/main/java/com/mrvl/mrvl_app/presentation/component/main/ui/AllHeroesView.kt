package com.mrvl.mrvl_app.presentation.component.main.ui

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.mrvl.mrvl_app.presentation.component.main.model.HeroPresentation
import com.mrvl.mrvl_app.presentation.core.mvp.presenter.BaseView

interface AllHeroesView : BaseView {

    @StateStrategyType(AddToEndStrategy::class)
    fun showHeroes(heroes: List<HeroPresentation>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun loadError()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun changeListSpan(isGrid: Boolean)
}