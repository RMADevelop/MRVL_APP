package com.mrvl.mrvl_app.core.presentation.screen

import android.content.Context
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager

interface Keyboard {

    fun Fragment.hideKeyboard() {
        requireActivity().currentFocus.let {
            val inputManager = requireActivity()
                    .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    fun Fragment.showKeyboard() {
        requireActivity().currentFocus.let {
            val inputMethodManager = requireActivity()
                    .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.showSoftInput(it, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}