package com.example.campsitecommanderapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.splashscreen)
        // Log for screen tracking
        Log.d("CampsiteCommander", "Splash Screen displayed")

        // Uses a Handler to transition after 3000ms as per requirements
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainScreen::class.java)
            startActivity(intent)
            finish() // Finish thee plash so the user cannot go back to it
            Log.d("CampsiteCommander", "Transitioning to Main Screen")
        }, 3000)
    }
}

