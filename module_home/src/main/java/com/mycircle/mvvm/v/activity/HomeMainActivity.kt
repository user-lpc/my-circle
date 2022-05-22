package com.mycircle.mvvm.v.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.mycircle.base.HomeBaseActivity
import com.mycircle.home.databinding.HomeActivityMainBinding
import com.mycircle.mvvm.vm.home.HomeMainViewModel
import com.mycircle.ui.BaseFragmentStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

/**
 * 首页
 *
 */
@AndroidEntryPoint
class HomeMainActivity : HomeBaseActivity<HomeActivityMainBinding, HomeMainViewModel>(){
    private val mCreateFragmentData = mutableListOf<String>()
    private var mAdapter: InternalPagerFragmentAdapter? = null

    override val mViewModel by viewModels<HomeMainViewModel>()

    override fun HomeActivityMainBinding.initView() {
        initPager()
    }

    override fun initObserve() {
    }

    private fun processData(data: String) {
    }

    override fun initRequestData() {
        checkLoginToStart<HomeMainActivity>()
    }


    private fun initPager() {
        mCreateFragmentData.add("首页")
        mCreateFragmentData.add("我的")
        mCreateFragmentData.add("设置")
        mCreateFragmentData.add("更多")
        mCreateFragmentData.add("动态")
        mAdapter = InternalPagerFragmentAdapter(this, mCreateFragmentData)
//        mBinding.viewPager.adapter = mAdapter

    }

    class InternalPagerFragmentAdapter(activity: FragmentActivity, data: MutableList<String> = mutableListOf()) :
        BaseFragmentStateAdapter<String>(activity, data) {
        override fun createFragment(item: String, position: Int): Fragment {
            val bundle = Bundle().apply {
                putString("What", item)
            }
//            return when (item) {
//                "首页" -> {
//                    //假装首页
//                    InternalFragment()
//                }
//                "我的" -> {
//                    //假装我的
//                    InternalFragment()
//                }
//                "设置" -> {
//                    //假装设置
//                    InternalFragment()
//                }
//                "更多" -> {
//                    //假装更多
//                    InternalFragment()
//                }
//                else -> {
//                    //另外动态item创建类型
//                    InternalFragment()
//                }
//            }.apply {
//                //设置传递参数bundle
//                arguments = bundle
//            }

            return Fragment()
        }


    }


}