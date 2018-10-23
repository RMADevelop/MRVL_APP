package com.mrvl.mrvl_app.core.extensions

import java.math.BigInteger
import java.security.MessageDigest


fun String.md5(): String {
    val digest: MessageDigest = MessageDigest.getInstance("MD5")
    digest.update(this.toByteArray())
    val digests: ByteArray = digest.digest()
    val hash = BigInteger(1, digest.digest())
    var md5hex = hash.toString(16)

    var result = hash.toString()
    while (md5hex.length < 32) {
        md5hex = "0$result"
    }


    val messageDigest = MessageDigest.getInstance("MD5")
    messageDigest.update(this.toByteArray())
    val hash1 = BigInteger(1, messageDigest.digest())
    var result1 = hash1.toString(16)
    while (result1.length < 32) {
        result1 = "0" + result1
    }

    return result1
}