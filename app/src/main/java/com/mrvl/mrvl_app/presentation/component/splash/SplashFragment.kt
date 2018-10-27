package com.mrvl.mrvl_app.presentation.component.splash

import android.graphics.drawable.AnimationDrawable
import android.support.v4.app.Fragment
import com.mrvl.mrvl_app.R
import com.mrvl.mrvl_app.core.presentation.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : BaseFragment<SplashView, SplashPresenter>() {

    override fun layoutId(): Int =
            R.layout.fragment_splash

    companion object {
        fun newInstance() = SplashFragment()
    }

    override fun onResume() {
        super.onResume()
        startAnimation()
    }

    private fun startAnimation() {
        val anim = container_splash.background as AnimationDrawable
        anim.start()
//        anim.setEnterFadeDuration(6000)
    }
}