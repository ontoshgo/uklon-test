package com.nookdev.uklontest.data

import android.net.NetworkInfo

interface NetworkStateChecker {
    fun getNetworkInfo(): NetworkInfo
}