package com.example.timerandworker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TimerAndWorkerFragment.newInstance())
            .commitNow()
    }

    private val NOTIFICATION_DELAY_IN_SECONDS = 5L

    override fun onDestroy() {
        super.onDestroy()

        val constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .setRequiresCharging(true)
            .setRequiresStorageNotLow(true)
            .build()

        val request = OneTimeWorkRequestBuilder<NotificationWorker>()
            .setConstraints(constraints)
            .setInitialDelay(NOTIFICATION_DELAY_IN_SECONDS, TimeUnit.SECONDS)
            .build()

        WorkManager.getInstance(this).enqueue(request)
    }
}