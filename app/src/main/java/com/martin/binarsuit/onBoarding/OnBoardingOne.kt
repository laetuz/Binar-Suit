package com.martin.binarsuit.onBoarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.martin.binarsuit.MainActivity
import com.martin.binarsuit.R
import kotlinx.android.synthetic.main.activity_on_boarding_parent.*

class OnBoardingOne : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_on_boarding_one, container, false)
    }

    companion object {
        fun newInstance(page: Int) = OnBoardingOne()
    }

   /* fun button() {
        button.setOnClickListener {
            Intent(context, MainActivity::class.java).also { startActivity(it) }
        }
    }*/
}