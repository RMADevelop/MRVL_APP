package com.mrvl.mrvl_app.core.presentation.list

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

class PagingScrollListener(
        private val loadMore: () -> Unit,
        private val isLoading: () -> Boolean
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        (recyclerView.layoutManager as LinearLayoutManager).run {
            val visibleItemCount = childCount
            val totalItemCount = itemCount
            val firstVisible = findFirstVisibleItemPosition()
            Log.d("tyghdfghfgdsfg", "tyghdfghfgdsfg " + totalItemCount + " ${isLoading()}")

            if (visibleItemCount + firstVisible >= totalItemCount && !isLoading() && totalItemCount > 0) {
//                Log.d("tyghdfghfgdsfg", "tyghdfghfgdsfg " + totalItemCount)
                loadMore()
            }
        }
//        val visibleItemCount = recyclerView.layoutManager?.childCount
//        val totalItemCount = recyclerView.layoutManager?.itemCount
//
//        val firstVisibleItemPosition = recyclerView.layoutManager?.vis
    }
}