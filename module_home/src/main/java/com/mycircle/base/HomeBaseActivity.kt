package com.mycircle.base

import android.app.Activity
import android.util.Log
import androidx.viewbinding.ViewBinding
import com.mycircle.base.mvvm.v.BaseFrameActivity
import com.mycircle.base.mvvm.vm.BaseViewModel
import com.mycircle.base.utils.ActivityStackManager
import com.mycircle.base.utils.AndroidBugFixUtils
import com.mycircle.base.utils.BarUtils
import com.mycircle.mvvm.v.activity.LoginActivity
import com.mycircle.utils.AccountUtils

/**
 * Activity基类
 *
 * @author Qu Yunshuo
 * @since 8/27/20
 */
abstract class HomeBaseActivity<VB : ViewBinding, VM : BaseViewModel> :
    BaseFrameActivity<VB, VM>() {

    /**
     * 设置状态栏
     * 子类需要自定义时重写该方法即可
     * @return Unit
     */
    override fun setStatusBar() {
        BarUtils.transparentStatusBar(this)
        BarUtils.setStatusBarLightMode(this, true)
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "ActivityStack: ${ActivityStackManager.activityStack}")
    }

    override fun onDestroy() {
        super.onDestroy()
        // 解决某些特定机型会触发的Android本身的Bug
        AndroidBugFixUtils().fixSoftInputLeaks(this)
    }

    /**
     * 登录状态检查
     * 初始化view的时候调用
     *
     * checkLoginToStart<LoginActivity>()
     */

    inline fun <reified T : Activity> Activity.checkLoginToStart(vararg params: Pair<String, Any>) {
        val isLogin = AccountUtils.checkLogin(this)
        if (isLogin) {
            Log.i("","登录成功")
        } else {
            startActivity(AccountUtils.createIntent(this@HomeBaseActivity, LoginActivity::class.java, *params))
        }
    }

}