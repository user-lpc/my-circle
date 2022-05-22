package com.mycircle.mvvm.v.fragment.home

import androidx.fragment.app.viewModels
import com.mycircle.base.ktx.observeLiveData
import com.mycircle.home.databinding.FragmentHomeMyBinding
import com.mycircle.mvvm.vm.home.HomeMyViewModel
import com.mycircle.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeMyFragment : BaseFragment<FragmentHomeMyBinding, HomeMyViewModel>() {

    override val mViewModel by viewModels<HomeMyViewModel>()

    override fun FragmentHomeMyBinding.initView() {
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