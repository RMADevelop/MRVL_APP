package com.mrvl.mrvl_app.data.allHero

import com.mrvl.mrvl_app.domain.allHero.AllHeroDomain
import com.mrvl.mrvl_app.domain.allHero.AllHeroesRequest
import io.reactivex.Single
import javax.inject.Inject


interface AllHeroRepository {
    fun getAllHero(allHeroesRequest: AllHeroesRequest): Single<AllHeroDomain>
}

class AllHeroDataRepository @Inject constructor(
        private val allHeroService: AllHeroService,
        private val allHeroMapperDtoToDomain: AllHeroMapperDtoToDomain
) : AllHeroRepository {

    override fun getAllHero(allHeroesRequest: AllHeroesRequest): Single<AllHeroDomain> =
            allHeroService.getAllHero(allHeroesRequest)
                    .map {
                        allHeroMapperDtoToDomain
                                .transform(
                                        it) }
}