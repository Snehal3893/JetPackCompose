package com.example.composedemo.workmanager

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificationWorker(context: Context,params:WorkerParameters) : Worker(context,params) {
    @SuppressLint("MissingPermission")
    override fun doWork(): Result {
        val notification=NotificationCompat.Builder(applicationContext,"default")
            .setContentTitle("Hi")
            .setContentText("Test")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()
        NotificationManagerCompat.from(applicationContext).notify(1,notification)
        return Result.success()
    }

}