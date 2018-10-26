package com.mrvl.mrvl_app.core.presentation.list

interface DataAdapter<Data> {

    fun setData(data: Data)

    fun addData(data: Data)
}

interface DiffAdapter<Item> {
    var diffUtilCallback: BaseDiffUtilCallback<Item>
}

