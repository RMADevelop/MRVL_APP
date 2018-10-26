package com.mrvl.mrvl_app.presentation.component.main.model

data class DataPresentation(
        val result: List<HeroPresentation>
)

data class HeroPresentation(
        val id: Long,
        var name: String,
        val description: String,
        val resourceLink: String,
        val thumbnailRemote: ThumbnailPresentation
)

data class ThumbnailPresentation(
        val pathImage: String,
        val extensionImage: String
)