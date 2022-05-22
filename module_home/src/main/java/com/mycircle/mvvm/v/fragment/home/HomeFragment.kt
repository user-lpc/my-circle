package com.mycircle.mvvm.v.fragment.home

import androidx.fragment.app.viewModels
import com.mycircle.base.ktx.observeLiveData
import com.mycircle.home.databinding.FragmentHomeBinding
import com.mycircle.mvvm.vm.home.HomeViewModel
import com.mycircle.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val mViewModel by viewModels<HomeViewModel>()

    override fun FragmentHomeBinding.initView() {
        // 初始化点击事件
    }

    override fun initObserve() {
        observeLiveData(mViewModel.infoData, ::processData)
    }

    private fun processData(data: String) {

    }

    override fun initRequestData() {
        //查询动态 展示最新动态信息
        mViewModel.infoData()
    }

}