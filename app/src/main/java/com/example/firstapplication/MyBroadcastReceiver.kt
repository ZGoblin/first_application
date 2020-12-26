package com.example.firstapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyBroadcastReceiver: BroadcastReceiver() {
    private val tag = "MY_BROADCAST_RECEIVER"

    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.also {
            if (it.action == FACTORIAL_IS_COUNTED) {
                val activity = context as MainActivity
                activity.intent.putExtra(resultNumber, it.getStringExtra(resultNumber).toString())
                activity.showFragment()
            }
        }
    }
}