package com.example.firstapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    private val tag = "MY_SERVICE"
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        Log.d(tag, "onCreate")
        super.onCreate()
    }

    override fun onDestroy() {
        Log.d(tag, "onDestroy")
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(tag, "OnStartCommand")
        task()
        return super.onStartCommand(intent, flags, startId)
    }

    fun task() {
        
    }
}