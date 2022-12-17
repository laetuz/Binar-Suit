package com.martin.binarsuit

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    private var locationManager: LocationManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        animateLogo() //Animating the logo
        delayHandler() //Delaying the splash screen
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
            Intent(this@SplashScreen, OnBoardingParent::class.java).also { startActivity(it) }
            finish()
        }, 1000)
    }

    // Disabling back button while on SplashScreen activity
    override fun onBackPressed() {
        // super.onBackPressed()
    }
}