package com.mrvl.mrvl_app.presentation.component.main.ui


import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.mrvl.mrvl_app.R
import com.mrvl.mrvl_app.core.presentation.screen.ToolbarConfig
import com.mrvl.mrvl_app.core.presentation.screen.ToolbarScreen
import com.mrvl.mrvl_app.core.presentation.view.BaseFragment
import com.mrvl.mrvl_app.di.ComponentManager
import kotlinx.android.synthetic.main.toolbar.*

class AllHeroesFragment
    : BaseFragment<AllHeroesView, AllHeroesPresenter>(), AllHeroesView, ToolbarScreen {
    @InjectPresenter
    lateinit var presenter: AllHeroesPresenter

    @ProvidePresenter
    fun providePresenter(): AllHeroesPresenter = provider.get()

    companion object {
        fun newInstance() = AllHeroesFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_main

    override fun getToolbar(): Toolbar = toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarSettings(ToolbarConfig(
                title = getString(R.string.all_heroes)
        ))
    }

    override fun inject() {
        ComponentManager.inject(this)
    }

    override fun showPlaceHolder() {
    }
}
