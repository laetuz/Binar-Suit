package com.martin.binarsuit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martin.binarsuit.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var nameUser: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameUser = binding.etUser.text.toString()

        button()
    }

    //Button leads to next activity
    private fun button() {
        binding.apply {
            btnLogin.setOnClickListener {
                nameUser
                val intentMain = Intent(this@LoginActivity, MenuActivity::class.java)
                intentMain.putExtra("name", nameUser)
                startActivity(intentMain)
                finishAffinity()
            }
        }
    }
}
