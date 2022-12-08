package com.martin.binarsuit.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.martin.binarsuit.R
import kotlinx.android.synthetic.main.activity_on_boarding_parent.*

class OnBoardingTwo : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /*button.setOnClickListener {  Intent(this@OnBoardingParent, MainActivity::class.java).also { startActivity(it) }
            .also {
                finishAffinity() }*/
        return inflater.inflate(R.layout.fragment_on_boarding_two, container, false)
    }

    companion object {
        fun newInstance(page:Int) = OnBoardingTwo()
    }

    /*fun button() {
        button= (view?.findViewById(R.id.button_next) ?: button.setOnClickListener {
            Intent(context, MainActivity::class.java).also { startActivity(it) }
        }) as ImageButton
    }*/
}