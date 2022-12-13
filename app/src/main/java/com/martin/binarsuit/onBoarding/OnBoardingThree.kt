package com.martin.binarsuit.onBoarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.martin.binarsuit.MenuActivity
import com.martin.binarsuit.R
import com.martin.binarsuit.databinding.FragmentOnBoardingThreeBinding
import kotlinx.android.synthetic.main.fragment_on_boarding_three.*

class OnBoardingThree : Fragment() {
    private lateinit var binding: FragmentOnBoardingThreeBinding
    private lateinit var nameUser: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: Set put extra intent 
        val nameUser = et_user.text.toString()
        nameUser
        val intentMain = Intent(context, MenuActivity::class.java)
        intentMain.putExtra("name", nameUser)
       /* button_next.setOnClickListener {
            Intent(context, LoginActivity::class.java).also { startActivity(it) }.also {
                activity?.finishAffinity()
            }
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_boarding_three, container, false)
    }

    companion object {
        fun newInstance(page:Int) = OnBoardingThree()
    }
}