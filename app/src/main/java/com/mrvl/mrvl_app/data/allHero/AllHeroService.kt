package com.mrvl.mrvl_app.data.allHero

import com.mrvl.mrvl_app.data.Api
import com.mrvl.mrvl_app.domain.allHero.AllHeroesRequest
import io.reactivex.Single
import javax.inject.Inject

interface AllHeroService {
    fun getAllHero(allHeroesRequest: AllHeroesRequest): Single<Unit>
}

class AllHeroDataService @Inject constructor(
        private val api: Api
) : AllHeroService {

    override fun getAllHero(allHeroesRequest: AllHeroesRequest): Single<Unit> =
            api.loadCharecters(
                    allHeroesRequest.limit,
                    allHeroesRequest.offset
            )
}