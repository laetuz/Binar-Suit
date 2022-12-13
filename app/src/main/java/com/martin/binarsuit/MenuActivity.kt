package com.martin.binarsuit

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martin.binarsuit.databinding.ActivityMenuBinding
import com.martin.binarsuit.databinding.DialogViewBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMenuBinding
    private lateinit var bindingDialog:DialogViewBinding
    private lateinit var nameLogin:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nameLogin = intent.getStringExtra("name").toString()
        getName()
        pickPlayer()
    }

    private fun getName(){
        binding.tvMenuPlayer.text = buildString {
            append("$nameLogin vs Pemain")
        }
        binding.tvMenuCpu.text = buildString {
            append("$nameLogin vs CPU")
        }
    }

    private fun pickPlayer(){
        binding.apply {
            //Pick player
            relPlayer.setOnClickListener {
                val intentMain = Intent(this@MenuActivity, PvpActivity::class.java)
                intentMain.putExtra("name", nameLogin)
                startActivity(intentMain)
                finishAffinity()
            }
            //Pick Computer!
            relCom.setOnClickListener {
                val intentMain = Intent(this@MenuActivity, MainActivity::class.java)
                intentMain.putExtra("name", nameLogin)
                startActivity(intentMain)
                finishAffinity()
            }
        }
    }

    override fun onBackPressed() {
        bindingDialog = DialogViewBinding.inflate(layoutInflater)
        val view = bindingDialog.root
        val builder = AlertDialog.Builder(this@MenuActivity)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        bindingDialog.btnBack.setOnClickListener { dialog.hide() }
        bindingDialog.btnExit.setOnClickListener { finish() }
    }
}