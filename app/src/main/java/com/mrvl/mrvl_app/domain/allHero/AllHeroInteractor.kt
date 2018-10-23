package com.mrvl.mrvl_app.domain.allHero

import com.mrvl.mrvl_app.data.allHero.AllHeroRepository
import io.reactivex.Single
import javax.inject.Inject

interface AllHeroInteractor {
    fun getAllHero(): Single<Unit>
}

class AllHeroDomainInteractor @Inject constructor(
        private val allHeroRepository: AllHeroRepository
) : AllHeroInteractor {

    private val allHeroesRequest = AllHeroesRequest()

    override fun getAllHero(): Single<Unit> =
            allHeroRepository.getAllHero(allHeroesRequest)
}

data class AllHeroesRequest(
        val limit: Int = 30,
        var offset: Int = 0
) {
    fun turnPage() {
        offset += limit
    }
}