package com.martin.binarsuit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martin.binarsuit.databinding.ActivityOnBoardingBinding

class OnBoarding : AppCompatActivity() {
    private lateinit var binding:ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnGame.setOnClickListener {
            Intent(this, MainActivity::class.java).
            also { startActivity(it)}.also { finishAffinity() }
        }
    }
}