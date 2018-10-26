package com.mrvl.mrvl_app.domain.allHero

data class AllHeroDomain(
        val statusCode: String,
        val dataRemote: DataDomain
)

data class DataDomain(
        val offset: Int,
        val limit: Int,
        val count: Int,
        val total: Int,
        val result: List<HeroDomain>
)

data class HeroDomain(
        val id: Long,
        val name: String,
        val description: String,
        val resourceLink: String,
        val thumbnailRemote: ThumbnailDomain
)

data class ThumbnailDomain(
        val pathImage: String,
        val extensionImage: String
)