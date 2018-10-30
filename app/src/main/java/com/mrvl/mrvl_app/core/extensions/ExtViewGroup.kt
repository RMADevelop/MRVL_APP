package com.mrvl.mrvl_app.core.extensions

import android.support.annotation.IdRes
import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.createView(idRes: Int, attachToRoot: Boolean) =
        LayoutInflater.from(context).inflate(idRes, this, attachToRoot)