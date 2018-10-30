package com.mrvl.mrvl_app.presentation.component.main.ui


import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
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
import com.mrvl.mrvl_app.data.core.ImageLoader
import com.mrvl.mrvl_app.di.ComponentManager
import com.mrvl.mrvl_app.presentation.component.main.adapter.AllHeroAdapter
import com.mrvl.mrvl_app.presentation.component.main.model.HeroPresentation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class AllHeroesFragment
    : BaseFragment<AllHeroesView, AllHeroesPresenter>(), AllHeroesView, ToolbarScreen {

    private lateinit var allHeroAdapter: AllHeroAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    private var isLoading = false

    @Inject
    lateinit var imageLoader: ImageLoader

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
        heroes_recycler_view.visibility = View.GONE
        initToolbar()
        initRecyclerView()
    }

    private fun changeLayoutManager() {
        presenter.changeButtonClicked()
    }

    override fun inject() {
        ComponentManager.inject(this)
    }

    override fun showPlaceHolder() {
    }

    override fun showHeroes(heroes: List<HeroPresentation>) {
        hideProgress()
        showContentIfHiding()
        isLoading = false
        allHeroAdapter.addData(heroes)
    }

    override fun loadError() {
        isLoading = false
    }

    override fun changeListSpan(isGrid: Boolean) {
        allHeroAdapter.spanChanged(isGrid)
    }

    private fun initRecyclerView() {

        gridLayoutManager = GridLayoutManager(context, 3).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(positioin: Int): Int {
                    return when (allHeroAdapter.getItemViewType(positioin)) {
                        R.layout.item_hero_linear -> 3
                        R.layout.item_hero_grid -> 1
                        R.layout.item_footer -> 3
                        else -> throw IllegalArgumentException("View type cannot be $this")
                    }
                }
            }
        }

        allHeroAdapter = AllHeroAdapter(
                imageLoader = imageLoader,
                itemClickListener = {
                    Toast.makeText(activity, "$it", Toast.LENGTH_LONG).show()
                }
        )

        with(heroes_recycler_view) {
            adapter = allHeroAdapter
            layoutManager = gridLayoutManager
            addOnScrollListener(PagingScrollListener(
                    {
                        isLoading = true
                        presenter.loadMore()
                    },
                    { isLoading },
                    {
                        toolbar.isSelected = it
                    }
            ))
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                    super.getItemOffsets(outRect, view, parent, state)
                    outRect.set(20, 30, 20, 30)
                }
            })
            addAnimation(R.anim.anim_linear_layout)
        }
    }

    private fun initToolbar() {
        setToolbarSettings(ToolbarConfig(
                title = getString(R.string.all_heroes)
        ))
        with(toolbar) {
            inflateMenu(R.menu.main_menu)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.linear_list,
                    R.id.grid_list -> changeLayoutManager()
                    else -> throw IllegalStateException("Unknown list manager ${it.itemId}")
                }
                return@setOnMenuItemClickListener true
            }
            isSelected = heroes_recycler_view.canScrollVertically(-1)
        }
    }

    private fun hideProgress() {
        progress_bar.visibility = View.GONE
    }

    private fun showContentIfHiding() {
        with(heroes_recycler_view) {
            if (visibility == View.GONE) {
                visibility = View.VISIBLE
            }
        }
    }
}

