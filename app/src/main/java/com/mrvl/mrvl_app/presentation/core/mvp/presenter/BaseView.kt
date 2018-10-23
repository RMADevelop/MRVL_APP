package com.mrvl.mrvl_app.presentation.core.mvp.presenter

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface BaseView : MvpView {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun showPlaceHolder()
}