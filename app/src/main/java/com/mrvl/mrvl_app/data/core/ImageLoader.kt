package com.mrvl.mrvl_app.data.core

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import javax.inject.Inject
import javax.inject.Singleton

data class ImageConfig(
        val imageView: ImageView,
        val url: String,
        val placeholder: Int? = null
)

@Singleton
class ImageLoader @Inject constructor() {

    fun loadImage(imageConfig: ImageConfig) {
        val request = Glide
                .with(imageConfig.imageView)
                .load(imageConfig.url)

        val options = RequestOptions()

        imageConfig.placeholder?.let {
            options.placeholder(it)
        }

        request.apply(options)
                .into(imageConfig.imageView)
    }
}