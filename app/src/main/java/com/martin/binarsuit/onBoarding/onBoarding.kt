package com.martin.binarsuit.onBoarding

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.martin.binarsuit.MainActivity
import com.martin.binarsuit.R
import com.martin.binarsuit.databinding.DialogViewBinding
import com.martin.binarsuit.databinding.FragmentOnBoardingBinding

class onBoarding : Fragment(R.layout.fragment_on_boarding) {
    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment


        glideView()
        return binding.root
    }


    //Display dialog. Menampilkan Dialog.
    /*fun onBackPressed() {
        bindingDialog = DialogViewBinding.inflate(layoutInflater)
        val view = bindingDialog.root
        val builder = AlertDialog.Builder(this@OnBoarding)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        bindingDialog.btnBack.setOnClickListener { dialog.hide() }
        bindingDialog.btnExit.setOnClickListener { finish() }
    }*/

    //Load Image
    fun glideView() {
        binding.apply {
            Glide.with(this@onBoarding)
                .load("https://st2.depositphotos.com/1340907/8260/v/450/depositphotos_82602614-stock-illustration-rock-paper-scissors.jpg")
                .fitCenter()
                .into(imageView)
        }
    }
}
