package com.mrvl.mrvl_app.presentation.component.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.mrvl.mrvl_app.R
import com.mrvl.mrvl_app.core.extensions.createView
import com.mrvl.mrvl_app.core.presentation.list.*
import com.mrvl.mrvl_app.data.core.ImageConfig
import com.mrvl.mrvl_app.data.core.ImageLoader
import com.mrvl.mrvl_app.presentation.component.main.model.HeroPresentation
import kotlinx.android.synthetic.main.item_hero_grid.*

class AllHeroAdapter(
        private var isGrid: Boolean = true,
        private val imageLoader: ImageLoader,
        private val itemClickListener: (HeroPresentation) -> Unit,
        override var diffUtilCallback: BaseDiffUtilCallback<List<HeroPresentation>> = DiffUtilCallback()
) : RecyclerView.Adapter<BaseViewHolder>(), DataAdapter<List<HeroPresentation>>, DiffAdapter<List<HeroPresentation>> {

    private var heroesList: MutableList<HeroPresentation> = ArrayList()

    override fun onCreateViewHolder(view: ViewGroup, type: Int): BaseViewHolder =
            view.run {
                when (type) {
                    R.layout.item_hero_linear -> HeroLinearViewHolder(
                            createView(R.layout.item_hero_linear, false),
                            imageLoader,
                            itemClickListener
                    )
                    R.layout.item_hero_grid -> HeroGridViewHolder(
                            createView(R.layout.item_hero_grid, false),
                            imageLoader,
                            itemClickListener
                    )
                    R.layout.item_footer -> FooterViewHolder(
                            createView(R.layout.item_footer, false)
                    )
                    else -> throw IllegalStateException("Illegal view type")
                }
            }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            itemCount - 1 -> R.layout.item_footer
            else -> if (isGrid) {
                R.layout.item_hero_grid
            } else {
                R.layout.item_hero_linear
            }
        }
    }

    override fun getItemCount(): Int = heroesList.size

    override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {
        when (viewHolder) {
            is HeroLinearViewHolder -> viewHolder.bind(heroesList[position])
            is HeroGridViewHolder -> viewHolder.bind(heroesList[position])
        }
    }

    override fun setData(data: List<HeroPresentation>) {
        heroesList = ArrayList(data)
    }

    override fun addData(data: List<HeroPresentation>) {
        val lastItemIndex = heroesList.size
        heroesList.addAll(data)
        notifyItemRangeInserted(lastItemIndex, data.size)
    }

    fun spanChanged(isGrid: Boolean) {
        this.isGrid = isGrid
        notifyItemRangeChanged(0, heroesList.size)
    }
}

class HeroLinearViewHolder(
        override val containerView: View,
        private val imageLoader: ImageLoader,
        itemClickDelegate: (HeroPresentation) -> Unit
) : ClickableViewHolder<HeroPresentation>(containerView, itemClickDelegate) {

    override lateinit var item: HeroPresentation

    override fun bind(item: HeroPresentation) {
        this.item = item
        item.apply {
            name_text_view.text = name
            val imageConfig = ImageConfig(hero_image_view, item.heroImageUrl.url())
            imageLoader.loadImage(imageConfig)
        }
    }
}

class HeroGridViewHolder(
        override val containerView: View,
        private val imageLoader: ImageLoader,
        itemClickDelegate: (HeroPresentation) -> Unit
) : ClickableViewHolder<HeroPresentation>(containerView, itemClickDelegate) {

    override lateinit var item: HeroPresentation

    override fun bind(item: HeroPresentation) {
        this.item = item
        name_text_view.text = item.name
        val imageConfig = ImageConfig(hero_image_view, item.heroImageUrl.url())
        imageLoader.loadImage(imageConfig)
    }
}

class FooterViewHolder(
        override val containerView: View
) : BaseViewHolder(containerView)