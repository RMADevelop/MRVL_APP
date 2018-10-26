package com.mrvl.mrvl_app.data.allHero

import com.google.gson.annotations.SerializedName

data class AllHeroRemote(
        @SerializedName("code") val statusCode: String,
        @SerializedName("data") val dataRemote: DataRemote
)

data class DataRemote(
        @SerializedName("offset") val offset: Int,
        @SerializedName("limit") val limit: Int,
        @SerializedName("count") val count: Int,
        @SerializedName("total") val total: Int,
        @SerializedName("results") val result: List<HeroRemote>
)

data class HeroRemote(
        @SerializedName("id") val id: Long,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String,
        @SerializedName("resourceURI") val resourceLink: String,
        @SerializedName("thumbnail") val thumbnailRemote: ThumbnailRemote
)

data class ThumbnailRemote(
        @SerializedName("path") val pathImage: String,
        @SerializedName("extension") val extensionImage: String
)