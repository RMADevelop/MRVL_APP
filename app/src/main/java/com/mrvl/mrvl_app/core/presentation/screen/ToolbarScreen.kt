package com.mrvl.mrvl_app.core.presentation.screen

import android.support.v7.widget.Toolbar
import android.view.View

data class ToolbarConfig(
        var title: String? = null,
        val withUpButton: Boolean = true,
        val navigationClickListener: View.OnClickListener? = null
)

interface ToolbarScreen {

    fun getToolbar(): Toolbar

    fun setToolbarSettings(toolbarConfig: ToolbarConfig) {
        with(getToolbar()) {
            title = toolbarConfig.title
            if (!toolbarConfig.withUpButton) navigationIcon = null
            setNavigationOnClickListener { toolbarConfig.navigationClickListener }
        }
    }
}