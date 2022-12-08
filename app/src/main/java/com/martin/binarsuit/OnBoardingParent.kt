package com.martin.binarsuit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martin.binarsuit.databinding.ActivityOnBoardingParentBinding
import com.martin.binarsuit.databinding.DialogViewBinding
import com.martin.binarsuit.onBoarding.onBoardingOne

class OnBoardingParent : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingParentBinding
    private lateinit var bindingDialog: DialogViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingParentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setFragment()
    }

    private fun setFragment(){
        val fragment = OnBoardingParent()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragOne,onBoardingOne()).commit()
        }
    }

}