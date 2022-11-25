package com.martin.binarsuit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        animateLogo()
        delayHandler()
    }

    // Animating the logo
    private fun animateLogo() {
        val spLogo: ImageView = findViewById(R.id.iv_logo)
        spLogo.animate().apply {
            duration = 700
            rotationBy(360f)
        }.start()
    }

    // Delaying the splash screen timeout and navigating to the OnBoarding activity
    private fun delayHandler() {
        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this@SplashScreen, OnBoarding::class.java).also { startActivity(it) }
            finish()
        }, 1000)
    }

    // Disabling back button while on SplashScreen activity
    override fun onBackPressed() {
        // super.onBackPressed()
    }
}