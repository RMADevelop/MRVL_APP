package com.mrvl.mrvl_app.core.domain

interface Mapper<From, To> {

    fun transform(from: From): To

    fun transformList(from: List<From>): List<To> = from.map { transform(it) }
}