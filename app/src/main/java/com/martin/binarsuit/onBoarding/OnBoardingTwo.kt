package com.martin.binarsuit.onBoarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import com.martin.binarsuit.MainActivity
import com.martin.binarsuit.R
import com.martin.binarsuit.databinding.FragmentOnBoardingTwoBinding
import kotlinx.android.synthetic.main.activity_on_boarding_parent.*
import kotlinx.android.synthetic.main.fragment_on_boarding_two.*

class OnBoardingTwo : Fragment() {
    private lateinit var binding:FragmentOnBoardingTwoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_next.setOnClickListener {
            Intent(context, MainActivity::class.java).also { startActivity(it) }.also {
                activity?.finishAffinity()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_boarding_two, container, false)
    }

    companion object {
        fun newInstance(page:Int) = OnBoardingTwo()
    }
}