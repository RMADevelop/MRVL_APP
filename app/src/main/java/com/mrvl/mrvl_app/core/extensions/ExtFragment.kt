package com.mrvl.mrvl_app.core.extensions

import android.os.Parcelable
import android.support.v4.app.Fragment

fun <Data : Parcelable> Fragment.getParcelable(keyParam: String): Data {
    return arguments?.getParcelable<Data>(keyParam)
            ?: throw NullPointerException("Argument cannot be a null")
}