package com.mrvl.mrvl_app.data.core.net

import com.mrvl.mrvl_app.core.extensions.md5
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    companion object {
        private const val API_KEY_PARAM = "apikey"
        private const val TIMESTAMP_PARAM = "ts"
        private const val HASH_PARAM = "hash"
        private const val PUBLIC_API_KEY = "edf79cd825e33b191eb3a661343674e9"
        private const val PRIVATE_API_KEY = "9fa4d7b994066c3219d469968d64e59c472fe7d9"
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        val timestamp = (System.currentTimeMillis() / 1000).toString()
        val hashMD5 = (timestamp + PRIVATE_API_KEY + PUBLIC_API_KEY).md5()

        var httpUrl = chain.request().url().newBuilder()
        with(httpUrl) {
            addQueryParameter(API_KEY_PARAM, PUBLIC_API_KEY)
            addQueryParameter(TIMESTAMP_PARAM, timestamp)
            addQueryParameter(HASH_PARAM, hashMD5)
        }

        return chain.proceed(
                chain.request().newBuilder()
                        .url(httpUrl.build())
                        .build()
        )
    }
}