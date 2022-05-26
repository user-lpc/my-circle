package com.mycircle.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeTabAdapter(manager: FragmentManager,val data: ArrayList<Fragment>,val lifecycle: Lifecycle): FragmentStateAdapter(manager,lifecycle){
    override fun getItemCount(): Int = data.size
    override fun createFragment(position: Int): Fragment = data[position]
}