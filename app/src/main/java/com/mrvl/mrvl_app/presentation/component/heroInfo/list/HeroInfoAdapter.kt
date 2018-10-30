package com.mrvl.mrvl_app.presentation.component.heroInfo.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.mrvl.mrvl_app.R
import com.mrvl.mrvl_app.core.extensions.createView

class HeroInfoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val IMAGE_VIEW_TYPE = 0
        private const val NAME_VIEW_TYPE = 1
        private const val COPYRIGHT_VIEW_TYPE = 10
    }

    override fun getItemViewType(position: Int): Int =
            when (position) {
                0 -> IMAGE_VIEW_TYPE
                1 -> NAME_VIEW_TYPE
                else -> COPYRIGHT_VIEW_TYPE
            }


    override fun onCreateViewHolder(viewgroup: ViewGroup, type: Int): RecyclerView.ViewHolder =
            when (type) {
                IMAGE_VIEW_TYPE -> HeroImageViewHolder(
                        itemView = viewgroup.createView(R.layout.item_hero_grid, false)
                )
                NAME_VIEW_TYPE -> HeroNameViewHolder(
                        itemView = viewgroup.createView(R.layout.item_hero_linear, false)
                )
                else -> HeroNameViewHolder(
                        itemView = viewgroup.createView(R.layout.item_hero_linear, false)
                )
            }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class HeroImageViewHolder(
        itemView: View
) : RecyclerView.ViewHolder(itemView)

class HeroNameViewHolder(
        itemView: View
) : RecyclerView.ViewHolder(itemView)