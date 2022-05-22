package com.mycircle.mvvm.v.fragment.home

import androidx.fragment.app.viewModels
import com.mycircle.base.ktx.observeLiveData
import com.mycircle.home.databinding.FragmentHomeCommunityBinding
import com.mycircle.mvvm.vm.home.HomeCommunityViewModel
import com.mycircle.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeCommunityFragment : BaseFragment<FragmentHomeCommunityBinding, HomeCommunityViewModel>() {

    override val mViewModel by viewModels<HomeCommunityViewModel>()

    override fun FragmentHomeCommunityBinding.initView() {
        // 初始化点击事件
    }

    override fun initObserve() {
        observeLiveData(mViewModel.infoData, ::processData)
    }

    private fun processData(data: String) {
        mBinding.tvHomeC.text = data

    }

    override fun initRequestData() {
        //查询动态 展示最新动态信息
        mViewModel.infoData()
    }

}