package com.mrvl.mrvl_app.core.extensions

import java.math.BigInteger
import java.security.MessageDigest

fun String.md5(): String {
    val messageDigest = MessageDigest.getInstance("MD5")
    messageDigest.update(this.toByteArray())
    val hash1 = BigInteger(1, messageDigest.digest())
    var result = hash1.toString(16)
    while (result.length < 32) {
        result = "0$result"
    }

    return result
}