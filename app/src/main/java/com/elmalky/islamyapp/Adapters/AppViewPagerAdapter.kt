package com.elmalky.islamyapp.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AppViewPagerAdapter(val constainer: FragmentActivity, val fragments: List<Fragment>) :
    FragmentStateAdapter(constainer) {
    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]
}