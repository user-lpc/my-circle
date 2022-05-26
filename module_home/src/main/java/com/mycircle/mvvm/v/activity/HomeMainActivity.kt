package com.mycircle.mvvm.v.activity

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.google.android.material.tabs.TabLayout
import com.mycircle.adapter.HomeTabAdapter
import com.mycircle.base.HomeBaseActivity
import com.mycircle.home.R
import com.mycircle.home.databinding.HomeActivityMainBinding
import com.mycircle.mvvm.m.home.HomeTitleModel
import com.mycircle.mvvm.v.fragment.home.HomeFragment
import com.mycircle.mvvm.v.fragment.home.HomeMyFragment
import com.mycircle.mvvm.vm.home.HomeMainViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * 首页
 *
 */
@AndroidEntryPoint
class HomeMainActivity : HomeBaseActivity<HomeActivityMainBinding, HomeMainViewModel>() {
    private val titleTabs = ArrayList<CustomTabEntity>()
    private val fragments = ArrayList<Fragment>()
    override val mViewModel by viewModels<HomeMainViewModel>()

    override fun HomeActivityMainBinding.initView() {
        val titles = resources.getStringArray(R.array.home_title)
        val unselectedList = resources.obtainTypedArray(R.array.home_unselected)
        val selectedList = resources.obtainTypedArray(R.array.home_select)

        for (i: Int in titles.indices) {
            titleTabs.add(
                HomeTitleModel(
                    titles[i],
                    selectedList.getResourceId(i, 0),
                    unselectedList.getResourceId(i, 0)
                )
            )
        }

        fragments.add(HomeFragment())
        fragments.add(HomeMyFragment())

        mBinding.ctlHomeMain.setTabData(titleTabs)
        mBinding.vpHomeMain.adapter=HomeTabAdapter(supportFragmentManager,fragments,lifecycle)
        mBinding.vpHomeMain.offscreenPageLimit = fragments.size
        mBinding.ctlHomeMain.setOnTabSelectListener(object :OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                //绑定fragment并取消进入动画
                mBinding.vpHomeMain.setCurrentItem(position,false)
            }

            override fun onTabReselect(position: Int) {
            }
        })


    }

    override fun initObserve() {
    }

    private fun processData(data: String) {
    }

    override fun initRequestData() {
        checkLoginToStart<HomeMainActivity>()
    }


}