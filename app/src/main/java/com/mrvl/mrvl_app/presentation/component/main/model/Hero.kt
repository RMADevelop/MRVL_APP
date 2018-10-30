package com.mrvl.mrvl_app.presentation.component.main.model

data class DataPresentation(
        val result: List<HeroPresentation>
)

data class HeroPresentation(
        val id: Long,
        var name: String,
        val description: String,
        val resourceLink: String,
        val heroImageUrl: HeroImageUrl
)

class HeroImageUrl(
        private val pathUrl: String,
        private val extensionImage: String,
        private val imageParam: ImageParam = ImageParam.PORTRAIT
) {
    companion object {
        private const val PORTRAINT_PATH = "/portrait_large."
        private const val STANDART_PATH = "/standart_large."
    }

    enum class ImageParam {
        PORTRAIT,
        STANDART;
    }

    fun url() =
            when (imageParam) {
                ImageParam.PORTRAIT -> pathUrl + PORTRAINT_PATH + extensionImage
                ImageParam.STANDART -> pathUrl + STANDART_PATH + extensionImage
            }
}