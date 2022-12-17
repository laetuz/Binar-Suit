package com.martin.binarsuit

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout
import com.martin.binarsuit.databinding.ActivityMenuBinding
import com.martin.binarsuit.databinding.DialogViewBinding
import com.martin.binarsuit.databinding.SnackbarCustomBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private lateinit var bindingDialog: DialogViewBinding
    private lateinit var nameLogin: String
    private lateinit var bindingSnack: SnackbarCustomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nameLogin = intent.getStringExtra("name").toString()
        getName()
        snackBar()
        pickPlayer()
    }

    private fun getName() {
        binding.tvMenuPlayer.text = buildString {
            append("$nameLogin vs Pemain")
        }
        binding.tvMenuCpu.text = buildString {
            append("$nameLogin vs CPU")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun snackBar() {
        val viewMenu = binding.root
        val snack = Snackbar.make(viewMenu, "", Snackbar.LENGTH_INDEFINITE)
        val customView = LayoutInflater.from(this).inflate(R.layout.snackbar_custom, null)
        val contentText = customView.findViewById<TextView>(R.id.tv_title)
        contentText.text = "Selamat Datang $nameLogin"
        snack.setAction("Dismiss") {}
        snack.setActionTextColor(Color.WHITE)
        snack.view.setBackgroundColor(Color.TRANSPARENT)
        val snackLayout = snack.view as SnackbarLayout
        snackLayout.setPadding(0, 0, 0, 0)
        snackLayout.addView(customView)
        snack.show()

    }

    private fun pickPlayer() {
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