 package com.example.firstapplication

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.firstapplication.databinding.ActivityMainBinding
import java.lang.NumberFormatException

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var receiver: MyBroadcastReceiver
    private lateinit var serviceIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupListener()
        receiver = MyBroadcastReceiver()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListener() {
        binding.btnStartService.setOnClickListener {
            serviceIntent = Intent(this, MyService::class.java)
            var num: Int = 1
            val str = binding.etnNumber.text.toString()
            if (str != "") num = str.toInt()
            serviceIntent.putExtra(takenNumber, num.toString())
            startService(serviceIntent)
        }
    }

    fun showFragment() {
        val fragment = FResultShower.newInstance()
        val bundle = Bundle()
        bundle.putString(resultNumber, intent.getStringExtra(resultNumber).toString())
        fragment.arguments = bundle

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.lMain, fragment)
                .addToBackStack("main")
                .commit()
    }

    override fun onStart() {
        super.onStart()

        val intentFilter = IntentFilter()
        intentFilter.addAction(FACTORIAL_IS_COUNTED)
        registerReceiver(receiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
        stopService(Intent(this, MyService::class.java))
    }
}