package com.mrvl.mrvl_app.core.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.mrvl.mrvl_app.presentation.core.mvp.presenter.BasePresenter
import com.mrvl.mrvl_app.presentation.core.mvp.presenter.BaseView
import javax.inject.Inject
import javax.inject.Provider

abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : MvpAppCompatFragment() {

    @Inject
    lateinit var provider: Provider<P>

    abstract fun layoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(layoutId(), container, false)


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }

    open protected fun inject() {}
}