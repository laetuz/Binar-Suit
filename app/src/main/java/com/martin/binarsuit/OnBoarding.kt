package com.martin.binarsuit

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martin.binarsuit.databinding.ActivityOnBoardingBinding
import com.martin.binarsuit.databinding.DialogViewBinding

class OnBoarding : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var bindingDialog: DialogViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnGame.setOnClickListener {
            Intent(this, MainActivity::class.java).also { startActivity(it) }
                .also { finishAffinity() }
        }
    }

    //Display dialog. Menampilkan Dialog.
    override fun onBackPressed() {
        bindingDialog = DialogViewBinding.inflate(layoutInflater)
        val view = bindingDialog.root
        val builder = AlertDialog.Builder(this@OnBoarding)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        bindingDialog.btnBack.setOnClickListener { dialog.hide() }
        bindingDialog.btnExit.setOnClickListener { finish() }
    }
}