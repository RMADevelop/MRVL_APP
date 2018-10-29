package com.mrvl.mrvl_app.presentation.component.splash

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.mrvl.mrvl_app.R
import com.mrvl.mrvl_app.core.presentation.view.BaseFragment
import com.mrvl.mrvl_app.di.ComponentManager
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : BaseFragment<SplashView, SplashPresenter>(), SplashView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter() =
            ComponentManager.mainComponent.splashComponent().presenter()

    private lateinit var splashListener: SplashListener

    lateinit var anim: AnimationDrawable

    override fun layoutId(): Int =
            R.layout.fragment_splash

    companion object {
        fun newInstance() = SplashFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        splashListener = context as SplashListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        anim = container_splash.background as AnimationDrawable
        with(anim) {
            isOneShot = true
            setExitFadeDuration(2000)
        }
    }

    override fun onResume() {
        super.onResume()
        anim.start()
        Handler().postDelayed({ presenter.splashShowed() }, 0)
    }

    override fun onDestroy() {
        super.onDestroy()
        splashListener.splashShowed()
    }

    override fun showPlaceHolder() {
    }
}

interface SplashListener {
    fun splashShowed()
}