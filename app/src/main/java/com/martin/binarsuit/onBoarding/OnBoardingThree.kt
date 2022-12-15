package com.martin.binarsuit.onBoarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.doOnTextChanged
import com.martin.binarsuit.MenuActivity
import com.martin.binarsuit.OnBoardingParent
import com.martin.binarsuit.R
import com.martin.binarsuit.databinding.FragmentOnBoardingThreeBinding
import kotlinx.android.synthetic.main.fragment_on_boarding_three.*

class OnBoardingThree : Fragment() {
    private lateinit var binding: FragmentOnBoardingThreeBinding
    private lateinit var nameUser: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        /*val button = activity?.findViewById<Button>(R.id.btn_login)
        button?.setOnClickListener {
            startActivity(intentMain)
        }*/


      //  val activityHost =
     /*   val buttonnext:Button= (getView()?.findViewById(R.id.btn_login) ?: intentMain.putExtra("name", nameUser)) as Button
        buttonnext.setOnClickListener {

        }*/

       /* button_next.setOnClickListener {
            Intent(context, LoginActivity::class.java).also { startActivity(it) }.also {
                activity?.finishAffinity()
            }
        }*/
    }

    /*private fun buttonExt(){
        binding.apply {
            etUser.doOnTextChanged { text, start, before, count ->
                (requireActivity() as OnBoardingParent).hideAndS
            }
        }
    }*/

    fun buttonOne():String{
        return et_user.text.toString()
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