package com.mrvl.mrvl_app.presentation.component.main.ui

import com.mrvl.mrvl_app.presentation.component.main.model.HeroPresentation
import com.mrvl.mrvl_app.presentation.core.mvp.presenter.BaseView

interface AllHeroesView : BaseView {

    fun showHeroes(heroes: List<HeroPresentation>)

    fun loadError()
}