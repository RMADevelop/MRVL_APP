package com.mrvl.mrvl_app.presentation.component.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mrvl.mrvl_app.R
import com.mrvl.mrvl_app.core.presentation.list.*
import com.mrvl.mrvl_app.presentation.component.main.model.HeroPresentation
import kotlinx.android.synthetic.main.item_hero.*

const val ITEM_VIEW_TYPE = 1
const val FOOTER_VIEW_TYPE = 2

class AllHeroAdapter(
        private val itemClickListener: (HeroPresentation) -> Unit,
        override var diffUtilCallback: BaseDiffUtilCallback<List<HeroPresentation>> = DiffUtilCallback()
) : RecyclerView.Adapter<BaseViewHolder>(), DataAdapter<List<HeroPresentation>>, DiffAdapter<List<HeroPresentation>> {

    private var heroesList: MutableList<HeroPresentation> = ArrayList()

    override fun onCreateViewHolder(view: ViewGroup, type: Int): BaseViewHolder =
            view.run {
                when (type) {
                    ITEM_VIEW_TYPE -> HeroViewHolder(
                            LayoutInflater.from(context)
                                    .inflate(R.layout.item_hero, this, false),
                            itemClickListener)
                    else -> FooterViewHolder(
                            LayoutInflater.from(context)
                                    .inflate(R.layout.item_footer, this, false)
                    )
                }
            }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            itemCount - 1 -> FOOTER_VIEW_TYPE
            else -> ITEM_VIEW_TYPE
        }
    }

    override fun getItemCount(): Int = heroesList.size

    override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {
        if (viewHolder is HeroViewHolder) {
            viewHolder.bind(heroesList[position])
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
}

class HeroViewHolder(
        override val containerView: View,
        itemClickDelegate: (HeroPresentation) -> Unit
) : ClickableViewHolder<HeroPresentation>(containerView, itemClickDelegate) {

    override lateinit var item: HeroPresentation

    override fun bind(item: HeroPresentation) {
        this.item = item
        item.apply {
            name_hero_text_view.text = name
        }
    }
}

class FooterViewHolder(
        override val containerView: View
) : BaseViewHolder(containerView)