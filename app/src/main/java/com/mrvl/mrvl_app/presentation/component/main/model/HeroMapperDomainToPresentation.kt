package com.mrvl.mrvl_app.presentation.component.main.model

import com.mrvl.mrvl_app.core.domain.Mapper
import com.mrvl.mrvl_app.domain.allHero.DataDomain
import javax.inject.Inject

class HeroMapperDomainToPresentation @Inject constructor() : Mapper<DataDomain, DataPresentation> {
    override fun transform(from: DataDomain): DataPresentation =
            from.run {
                DataPresentation(
                        result = result.map {
                            HeroPresentation(
                                    id = it.id,
                                    name = it.name,
                                    description = it.description,
                                    resourceLink = it.resourceLink,
                                    heroImageUrl = it.thumbnailRemote.run {
                                        HeroImageUrl(
                                                pathUrl = pathImage,
                                                extensionImage = extensionImage
                                        )
                                    }
                            )
                        }
                )
            }
}