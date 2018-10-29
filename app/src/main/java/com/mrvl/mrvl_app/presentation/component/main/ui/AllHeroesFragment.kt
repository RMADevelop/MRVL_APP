package com.mrvl.mrvl_app.presentation.component.main.ui


import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.mrvl.mrvl_app.R
import com.mrvl.mrvl_app.core.extensions.addAnimation
import com.mrvl.mrvl_app.core.presentation.list.PagingScrollListener
import com.mrvl.mrvl_app.core.presentation.screen.ToolbarConfig
import com.mrvl.mrvl_app.core.presentation.screen.ToolbarScreen
import com.mrvl.mrvl_app.core.presentation.view.BaseFragment
import com.mrvl.mrvl_app.di.ComponentManager
import com.mrvl.mrvl_app.presentation.component.main.adapter.AllHeroAdapter
import com.mrvl.mrvl_app.presentation.component.main.adapter.FOOTER_VIEW_TYPE
import com.mrvl.mrvl_app.presentation.component.main.adapter.ITEM_VIEW_TYPE
import com.mrvl.mrvl_app.presentation.component.main.model.HeroPresentation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.toolbar.*

class AllHeroesFragment
    : BaseFragment<AllHeroesView, AllHeroesPresenter>(), AllHeroesView, ToolbarScreen {

    private lateinit var allHeroAdapter: AllHeroAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var gridLayoutManager: GridLayoutManager
    private var isLoading = false

    @InjectPresenter
    lateinit var presenter: AllHeroesPresenter

    @ProvidePresenter
    fun providePresenter(): AllHeroesPresenter = provider.get()

    companion object {
        private const val LINEAR_MANAGER = "linear_manager"
        private const val GRID_MANAGER = "grid_manager"

        fun newInstance() = AllHeroesFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_main

    override fun getToolbar(): Toolbar = toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarSettings(ToolbarConfig(
                title = getString(R.string.all_heroes)
        ))
        toolbar.inflateMenu(R.menu.main_menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.linear_list -> changeLayoutManager(LINEAR_MANAGER)
                R.id.grid_list -> changeLayoutManager(GRID_MANAGER)
                else -> throw IllegalStateException("Unknown list manager ${it.itemId}")
            }
        }
        allHeroAdapter = AllHeroAdapter({
            Toast.makeText(activity, "$it", Toast.LENGTH_LONG).show()
        })
        linearLayoutManager = LinearLayoutManager(context)
        gridLayoutManager = GridLayoutManager(context, 2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(positioin: Int): Int {
                    return when (allHeroAdapter.getItemViewType(positioin)) {
                        ITEM_VIEW_TYPE -> 1
                        FOOTER_VIEW_TYPE -> 2
                        else -> throw IllegalArgumentException("View type cannot be $this")
                    }
                }
            }
        }

        with(heroes_recycler_view) {
            adapter = allHeroAdapter
            layoutManager = linearLayoutManager
            addOnScrollListener(PagingScrollListener(
                    {
                        isLoading = true
                        presenter.loadMore()
                    },
                    { isLoading }
            ))
            addAnimation(R.anim.anim_linear_layout)
        }
    }

    private fun changeLayoutManager(layoutManager: String): Boolean {
        Log.d("dfhjvsdhnvsjkdv", layoutManager)
        when (layoutManager) {
            LINEAR_MANAGER -> {
//                if (heroes_recycler_view.layoutManager !is LinearLayoutManager) {
                Log.d("dfhjvsdhnvsjkdv", " linear begin")
                with(heroes_recycler_view) {
                    addAnimation(R.anim.anim_linear_layout)
                    setLayoutManager(linearLayoutManager)
                    adapter = allHeroAdapter
                    adapter?.notifyDataSetChanged()
                }
//                }
            }
            GRID_MANAGER -> {
//                if (heroes_recycler_view.layoutManager !is GridLayoutManager) {
                Log.d("dfhjvsdhnvsjkdv", " grid begin")
                with(heroes_recycler_view) {
                    addAnimation(R.anim.anim_linear_layout)
                    setLayoutManager(gridLayoutManager)
                    adapter = allHeroAdapter
                    adapter?.notifyDataSetChanged()
                }
//                }
            }
            else -> throw IllegalArgumentException("Unknown layout manager")
        }
        return true
    }

    override fun inject() {
        ComponentManager.inject(this)
    }

    override fun showPlaceHolder() {
    }

    override fun showHeroes(heroes: List<HeroPresentation>) {
        isLoading = false
        allHeroAdapter.addData(heroes)
    }

    override fun loadError() {
        isLoading = false
    }
}

