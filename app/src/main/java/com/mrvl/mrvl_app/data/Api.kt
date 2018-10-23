package com.mrvl.mrvl_app.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("v1/public/characters")
    fun loadCharecters(
            @Query("limit") limit: Int,
            @Query("offset") offset: Int
    ) : Single<Unit>
}