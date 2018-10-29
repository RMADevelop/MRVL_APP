package com.mrvl.mrvl_app.core.extensions

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.animation.AnimationUtils
import com.mrvl.mrvl_app.core.presentation.list.DataAdapter
import com.mrvl.mrvl_app.core.presentation.list.DiffAdapter


fun <Adapter, Data> Adapter.setItems(
        newItems: Data,
        withAnim: Boolean = true
) where Adapter : RecyclerView.Adapter<*>,
        Adapter : DiffAdapter<Data>,
        Adapter : DataAdapter<Data> {
    diffUtilCallback.setItems(newItems)
    val result = DiffUtil.calculateDiff(diffUtilCallback, withAnim)
    setData(newItems)
    result.dispatchUpdatesTo(this)
}

fun RecyclerView.addAnimation(animationId: Int) {
    val anim = AnimationUtils.loadLayoutAnimation(context, animationId)
    layoutAnimation = anim
}

fun RecyclerView.rerunAnimIfEmptyList() {

}