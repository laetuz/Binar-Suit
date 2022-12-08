package com.martin.binarsuit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martin.binarsuit.adapter.ObAdapter
import com.martin.binarsuit.databinding.ActivityOnBoardingParentBinding
import com.martin.binarsuit.databinding.DialogViewBinding
import kotlinx.android.synthetic.main.activity_on_boarding_parent.*
import me.relex.circleindicator.CircleIndicator3

class OnBoardingParent : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingParentBinding
    private lateinit var bindingDialog: DialogViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingParentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setViewPager()
    }

    private fun setViewPager() {
        binding.apply {
            vpOne.apply {
                adapter = ObAdapter(this@OnBoardingParent)
                currentItem = 0
            }
            binding.indicator.setViewPager(vpOne)
        }
    }

    /*private fun button() {
        binding.apply {
            button.setOnClickListener {
                Intent(this@OnBoardingParent, MainActivity::class.java).also { startActivity(it) }
                    .also {
                        finishAffinity()
                    }
            }
        }
    }*/
}