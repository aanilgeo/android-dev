package com.example.chowspot

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationsUtils {

    private const val CHANNEL_ID = "funFactsChannel"
    private const val CHANNEL_NAME = "Fun Facts Notifications"
    private const val CHANNEL_DESCRIPTION = "Channel for Fun Facts notifications"

    fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = CHANNEL_DESCRIPTION
            }

            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun sendFunFactNotification(context: Context) {

        // Check for notification permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ActivityCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
        ) {
            // Permission not granted; do nothing or handle appropriately
            return
        }

        // Fun facts to display
        val funFactsList = listOf(
            "The world's most expensive pizza costs $12,000!",
            "Honey is the only food that doesn’t spoil.",
            "Bananas are berries, but strawberries aren’t.",
            "Apples float in water because they are 25% air."
        )

        // Randomly pick a fun fact
        val randomFunFact = funFactsList.random()

        // Build the notification
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification) // Replace with your app's notification icon
            .setContentTitle("Did You Know?")
            .setContentText(randomFunFact)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()

        // Show the notification
        NotificationManagerCompat.from(context).notify((0..10000).random(), notification)
    }
}