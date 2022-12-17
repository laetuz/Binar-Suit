package com.martin.binarsuit

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.martin.binarsuit.adapter.ObAdapter
import com.martin.binarsuit.adapter.ObAdapter.Companion.FIRST
import com.martin.binarsuit.adapter.ObAdapter.Companion.SECOND
import com.martin.binarsuit.adapter.ObAdapter.Companion.THREE
import com.martin.binarsuit.databinding.ActivityOnBoardingParentBinding
import com.martin.binarsuit.databinding.DialogViewBinding
import com.martin.binarsuit.onBoarding.OnBoardingThree

class OnBoardingParent : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingParentBinding
    private lateinit var bindingDialog: DialogViewBinding
    private lateinit var adapterOb: ObAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingParentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setViewPager() //Shows the viewpager.
        setButton() //
    }

    //Shows the viewpager. Menampilkan viewpager.
    private fun setViewPager() {
        binding.apply {
            vpOne.apply {
                adapterOb = ObAdapter(this@OnBoardingParent)
                adapter = adapterOb
                currentItem = 0
            }
                .registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        when (position) {
                            FIRST -> {
                                btnLogin.visibility = View.GONE
                            }
                            SECOND -> {
                                btnLogin.visibility = View.GONE
                            }
                            THREE -> {
                                btnLogin.visibility = View.VISIBLE
                            }
                        }
                    }
                })
            indicator.setViewPager(vpOne)
        }
    }

    //Set button function.
    private fun setButton() {
        binding.apply {
            btnLogin.setOnClickListener {
                val fragment = adapterOb.getFragment(vpOne.currentItem)
                //Getting the editText intent from OnBoarding Three.
                if (fragment is OnBoardingThree) {
                    //Send the editText intent to Menu Activity.
                    Intent(this@OnBoardingParent, MenuActivity::class.java)
                        .apply { putExtra("name", fragment.buttonOne()) }.also {
                            startActivity(it)
                            finishAffinity()
                        }
                }
            }
        }
    }

    override fun onBackPressed() {
        bindingDialog = DialogViewBinding.inflate(layoutInflater)
        val view = bindingDialog.root
        val builder = AlertDialog.Builder(this@OnBoardingParent)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        bindingDialog.btnBack.setOnClickListener { dialog.hide() }
        bindingDialog.btnExit.setOnClickListener { finish() }
    }
}