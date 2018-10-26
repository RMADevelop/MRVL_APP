package com.mrvl.mrvl_app.data.allHero

import com.mrvl.mrvl_app.core.domain.Mapper
import com.mrvl.mrvl_app.domain.allHero.AllHeroDomain
import com.mrvl.mrvl_app.domain.allHero.DataDomain
import com.mrvl.mrvl_app.domain.allHero.HeroDomain
import com.mrvl.mrvl_app.domain.allHero.ThumbnailDomain
import javax.inject.Inject

class AllHeroMapperDtoToDomain @Inject constructor() : Mapper<AllHeroRemote, AllHeroDomain> {

    override fun transform(from: AllHeroRemote): AllHeroDomain =
            from.run {
                AllHeroDomain(
                        statusCode = statusCode,
                        dataRemote = dataRemote.run {
                            DataDomain(
                                    offset = offset,
                                    limit = limit,
                                    count = count,
                                    total = total,
                                    result = result.map {
                                        HeroDomain(
                                                id = it.id,
                                                name = it.name,
                                                description = it.description,
                                                resourceLink = it.resourceLink,
                                                thumbnailRemote = it.thumbnailRemote.run {
                                                    ThumbnailDomain(
                                                            pathImage = pathImage,
                                                            extensionImage = extensionImage
                                                    )
                                                }
                                        )
                                    }
                            )
                        }
                )
            }
}