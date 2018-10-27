package com.mrvl.mrvl_app.presentation.component.heroInfo.ui

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.mrvl.mrvl_app.R
import com.mrvl.mrvl_app.core.extensions.getParcelable
import com.mrvl.mrvl_app.core.presentation.view.BaseFragment
import com.mrvl.mrvl_app.di.ComponentManager

class HeroInfoFragment : BaseFragment<HeroInfoView, HeroInfoPresenter>(), HeroInfoView {

    @InjectPresenter
    lateinit var heroInfoPresenter: HeroInfoPresenter

    @ProvidePresenter
    fun providePresenter() =
            ComponentManager.mainComponent.heroInfoComponent().providePresenter()

    override fun layoutId(): Int =
            R.layout.fragment_hero_info

    companion object {
        private const val HERO_INFO_PARAM = "HERO_INFO_PARAM"

        fun newInstance(heroInfoFragmentParams: HeroInfoFragmentParams) =
                HeroInfoFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(HERO_INFO_PARAM, heroInfoFragmentParams)
                    }
                }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(getParcelable<HeroInfoFragmentParams>(HERO_INFO_PARAM)) {
            //TODO
        }
    }

    override fun showPlaceHolder() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
