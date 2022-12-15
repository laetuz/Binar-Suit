package com.martin.binarsuit.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.martin.binarsuit.onBoarding.OnBoardingTwo
import com.martin.binarsuit.onBoarding.OnBoardingOne
import com.martin.binarsuit.onBoarding.OnBoardingThree

class ObAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragmentsData = listOf(
        OnBoardingOne.newInstance(FIRST),
        OnBoardingTwo.newInstance(SECOND),
        OnBoardingThree.newInstance(THREE)
    )

    companion object {
        const val FIRST = 0
        const val SECOND = 1
        const val THREE = 2
    }

    override fun getItemCount(): Int {
        return fragmentsData.size
    }

    fun getFragment(position: Int): Fragment = fragmentsData[position]

    override fun createFragment(position: Int): Fragment = fragmentsData[position]
}