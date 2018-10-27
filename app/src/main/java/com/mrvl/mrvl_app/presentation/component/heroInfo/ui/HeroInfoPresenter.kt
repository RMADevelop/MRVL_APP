package com.mrvl.mrvl_app.presentation.component.heroInfo.ui

import android.os.Parcelable
import com.arellomobile.mvp.InjectViewState
import com.mrvl.mrvl_app.presentation.core.mvp.presenter.BasePresenter
import kotlinx.android.parcel.Parcelize
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@Parcelize
data class HeroInfoFragmentParams(
        val heroPresentation: String
) : Parcelable

@InjectViewState
class HeroInfoPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<HeroInfoView>()