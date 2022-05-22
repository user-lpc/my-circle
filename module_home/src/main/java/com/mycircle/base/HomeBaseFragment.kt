package com.mycircle.base

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.mycircle.base.mvvm.v.BaseFrameFragment
import com.mycircle.base.mvvm.vm.BaseViewModel
import com.mycircle.mvvm.v.activity.LoginActivity
import com.mycircle.utils.AccountUtils

/**
 * Fragment基类
 *
 */
abstract class HomeBaseFragment<VB : ViewBinding, VM : BaseViewModel> : BaseFrameFragment<VB, VM>()


/**
 * 检查登录状态
 *
 * checkLoginToStart<LoginActivity>()
 */
inline fun <reified T : Fragment> Fragment.checkLoginToStart(vararg params: Pair<String, Any>) {
    val isLogin = AccountUtils.checkLogin(this)
    if (isLogin) {
        Log.i("","登录成功")
    } else {
        startActivity(AccountUtils.createIntent(this.requireContext(), LoginActivity::class.java, *params))
    }
}