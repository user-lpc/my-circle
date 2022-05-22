package com.mycircle.mvvm.v.activity

import androidx.activity.viewModels
import com.mycircle.base.ktx.observeLiveData
import com.mycircle.base.HomeBaseActivity
import com.mycircle.home.databinding.HomeActivityMainBinding
import com.mycircle.mvvm.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * 首页
 *
 * @author Qu Yunshuo
 * @since 5/22/21 2:26 PM
 */
@AndroidEntryPoint
class MainActivity : HomeBaseActivity<HomeActivityMainBinding, HomeViewModel>(){

    /**
     * 通过 viewModels() + Hilt 获取 ViewModel 实例
     */
    override val mViewModel by viewModels<HomeViewModel>()

    override fun HomeActivityMainBinding.initView() {

    }

    override fun initObserve() {
        observeLiveData(mViewModel.data, ::processData)
    }

    private fun processData(data: String) {
    }

    override fun initRequestData() {
        checkLoginToStart<MainActivity>()
    }

}