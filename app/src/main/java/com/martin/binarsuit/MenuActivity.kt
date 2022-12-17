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

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private lateinit var bindingDialog: DialogViewBinding
    private lateinit var nameLogin: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Getting the editText intent from OnBoardingParent.
        nameLogin = intent.getStringExtra("name").toString()

        getName() //Get the name intent.
        snackBar() //Show the snack bar.
        pickPlayer() //Pick the game mode.
    }

    //Get the name intent. Mendapatkan intent nama.
    private fun getName() {
        binding.tvMenuPlayer.text = buildString {
            append("$nameLogin vs Pemain")
        }
        binding.tvMenuCpu.text = buildString {
            append("$nameLogin vs CPU")
        }
    }

    //Show the snack bar. Menampilkan snack bar.
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

    //Pick the game mode. Memilih mode permainan.
    private fun pickPlayer() {
        binding.apply {
            //Pick player! Memilih mode melawan player.
            relPlayer.setOnClickListener {
                val intentMain = Intent(this@MenuActivity, PvpActivity::class.java)
                intentMain.putExtra("name", nameLogin)
                startActivity(intentMain)
                finishAffinity()
            }
            //Pick Computer! Memilih mode melawan komputer.
            relCom.setOnClickListener {
                val intentMain = Intent(this@MenuActivity, MainActivity::class.java)
                intentMain.putExtra("name", nameLogin)
                startActivity(intentMain)
                finishAffinity()
            }
        }
    }

    //Shows dialog when user use back navigation.
    // Menampilkan dialog ketika user memberi navigasi kembali.
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