package com.mrvl.mrvl_app.core.presentation.list

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder(
        containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer

abstract class BindableViewHolder<Item>(
        containerView: View
) : BaseViewHolder(containerView), Bindable<Item>

abstract class ClickableViewHolder<Item>(
        containerView: View,
        override var itemClick: (Item) -> Unit
) : BindableViewHolder<Item>(containerView), Clickable<Item> {
    init {
        containerView.setOnClickListener {
            itemClick(item)
        }
    }
}

interface Clickable<Item> {
    var itemClick: (item: Item) -> Unit
}

interface Bindable<Item> {
    var item: Item
    fun bind(item: Item)
}