package com.mrvl.mrvl_app.core.presentation.list

import android.support.v7.util.DiffUtil
import android.util.Log

abstract class BaseDiffUtilCallback<Item> : DiffUtil.Callback() {

    protected var old: Item? = null
    protected var new: Item? = null

    fun setItems(items: Item) {
        Log.d("setIteeeeem", " $old  \n $new")
        old = new
        new = items
    }
}

class DiffUtilCallback<Item> : BaseDiffUtilCallback<List<Item>>() {

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        val oldItems = old ?: return false
        val newItems = new ?: return false

        return oldItems[oldPosition]?.hashCode() == newItems[newPosition]?.hashCode()
    }

    override fun getOldListSize(): Int =
            old?.size ?: 0

    override fun getNewListSize(): Int =
            new?.size ?: 0

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        val oldItems = old ?: return false
        val newItems = new ?: return false

        return oldItems[oldPosition] == newItems[newPosition]
    }
}