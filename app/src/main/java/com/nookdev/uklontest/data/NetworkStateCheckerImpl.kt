package com.nookdev.uklontest.data

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class NetworkStateCheckerImpl @Inject constructor(
    private val context: Context
) : NetworkStateChecker {

    override fun isConnected(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return try {
            connectivityManager.activeNetworkInfo.isConnected
        } catch (e: IllegalStateException) {
            false
        }
    }

}