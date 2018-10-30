package com.mrvl.mrvl_app.core.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.ConnectivityManager.CONNECTIVITY_ACTION
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject

class Connection(
        context: Context,
        private val connectivityManager: ConnectivityManager
) : BroadcastReceiver() {
    private val subject = BehaviorSubject.createDefault(checkConnection())

    init {
        context.registerReceiver(this, IntentFilter(CONNECTIVITY_ACTION))
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        publishStatus()
    }

    fun isConnected() = Single.fromCallable { checkConnection() }

    fun observeConnection() = subject

    fun checkConnection() =
            with(connectivityManager.activeNetworkInfo) {
                return@with isConnected
            }

    fun publishStatus() {
        subject.onNext(checkConnection())
    }
}