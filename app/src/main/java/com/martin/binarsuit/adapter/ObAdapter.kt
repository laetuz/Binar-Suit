package com.martin.binarsuit.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.martin.binarsuit.onBoarding.OnBoardingTwo
import com.martin.binarsuit.onBoarding.OnBoardingOne

class ObAdapter (fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){

    private val fragmentsData = listOf(
        OnBoardingOne.newInstance(FIRST),
        OnBoardingTwo.newInstance(SECOND),
    )

    companion object{
        const val FIRST = 0
        const val SECOND = 1
    }

    override fun getItemCount(): Int {
        return fragmentsData.size
    }

    override fun createFragment(position: Int): Fragment = fragmentsData[position]
}