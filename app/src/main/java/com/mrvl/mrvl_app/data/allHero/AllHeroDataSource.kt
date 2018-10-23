package com.mrvl.mrvl_app.data.allHero

import com.mrvl.mrvl_app.domain.allHero.AllHeroesRequest
import io.reactivex.Single
import javax.inject.Inject


interface AllHeroRepository {
    fun getAllHero(allHeroesRequest: AllHeroesRequest): Single<Unit>
}

class AllHeroDataRepository @Inject constructor(
        private val allHeroService: AllHeroService
) : AllHeroRepository {

    override fun getAllHero(allHeroesRequest: AllHeroesRequest): Single<Unit> =
            allHeroService.getAllHero(allHeroesRequest)
}