package com.example.articlesearchpt3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log

class NetworkReceiver(
    private val onNetworkAvailable: () -> Unit,
    private val onNetworkUnavailable: () -> Unit
) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        if (intent == null || intent.action != ConnectivityManager.CONNECTIVITY_ACTION) {
            Log.w("NetworkReceiver", "Received null or irrelevant intent.")
            return
        }

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network)

        if (networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true) {
            Log.d("NetworkReceiver", "Network is available.")
            onNetworkAvailable()
        } else {
            Log.d("NetworkReceiver", "Network is unavailable.")
            onNetworkUnavailable()
        }
    }
}