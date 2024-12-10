package com.example.chowspot

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LoginPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) LoginFragment() else SignUpFragment()
    }
}
