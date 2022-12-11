package com.martin.binarsuit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martin.binarsuit.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button()
    }

    //Button leads to next activity
    private fun button() {
        binding.apply {
            etUser.text.toString()
        }
        binding.apply {
            btnLogin.setOnClickListener {
                val nameUser = etUser.text.toString()
                val intentMain = Intent(this@LoginActivity, MenuActivity::class.java)
                intentMain.putExtra("name", nameUser)
                startActivity(intentMain)
                finishAffinity()
            }
        }
    }
}
