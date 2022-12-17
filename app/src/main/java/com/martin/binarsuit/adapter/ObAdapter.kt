package com.martin.binarsuit.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.martin.binarsuit.onBoarding.OnBoardingTwo
import com.martin.binarsuit.onBoarding.OnBoardingOne
import com.martin.binarsuit.onBoarding.OnBoardingThree

class ObAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    //Set the size of fragments. Get the fragments instance.
    private val fragmentsData = listOf(
        OnBoardingOne.newInstance(FIRST),
        OnBoardingTwo.newInstance(SECOND),
        OnBoardingThree.newInstance(THREE)
    )

    //Set up the position of viewpager pages.
    companion object {
        const val FIRST = 0
        const val SECOND = 1
        const val THREE = 2
    }

    //Get the size of fragment from fragmentsData list.
    override fun getItemCount(): Int {
        return fragmentsData.size
    }

    //Get the position of fragment.
    fun getFragment(position: Int): Fragment = fragmentsData[position]

    //Set the position of fragment.
    override fun createFragment(position: Int): Fragment = fragmentsData[position]
}