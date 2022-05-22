package com.mycircle.mvvm.v.activity

import android.content.Intent
import androidx.activity.viewModels
import com.mycircle.base.HomeBaseActivity
import com.mycircle.base.ktx.observeLiveData
import com.mycircle.home.databinding.ActivityLoginBinding
import com.mycircle.pojo.TopNew
import com.mycircle.mvvm.vm.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : HomeBaseActivity<ActivityLoginBinding, LoginViewModel>(){

    override val mViewModel by viewModels<LoginViewModel>()

    override fun ActivityLoginBinding.initView() {
        //登录按钮事件
        mBinding.btLoginSignup.setOnClickListener {
            val phone = mBinding.etLoginPhoneInput.text
            val pwd = mBinding.etLoginPwdInput.text
            if (mViewModel.login(phone,pwd)) {
                //登录成功，默认跳转首页
                startActivity(Intent(this@LoginActivity,HomeMainActivity::class.java))
            }else{
                //登陆失败
                println(phone)
                println(pwd)
            }

        }
    }

    override fun initObserve() {
        observeLiveData(mViewModel.data, ::processData)
    }

    private fun processData(data: TopNew) {
        mBinding.tvLoginSpan.text = data.Data.toString()
    }


    override fun initRequestData() {
        mViewModel.getTest()
    }

}
