package com.mycircle.mvvm.m.home

import com.flyco.tablayout.listener.CustomTabEntity

data class HomeTitleModel(val title:String,val selected:Int,val unselected:Int): CustomTabEntity {
    override fun getTabTitle(): String =title
    override fun getTabSelectedIcon(): Int =selected
    override fun getTabUnselectedIcon(): Int =unselected

}
