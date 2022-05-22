package com.mycircle.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment


object AccountUtils {

    const val PARAMS = "PARAMS"
    const val TARGET = "TARGET"

    /**
     * 跳转页面
     */
    fun <T> createIntent(context: Context?, java: Class<T>, vararg params: Pair<String, Any>) : Intent {
        val i = Intent(context, java)
        i.putExtra(TARGET, "${java.`package`}.${java.simpleName}")
        i.putExtra(PARAMS, params)
        return i
    }

    /**
     *获取androidId  根据androidId判断当前设备是否登录
     */
    @SuppressLint("HardwareIds")
    inline fun <reified T> checkLogin(fragment: T): Boolean {

        var androidId = ""
        when (fragment) {
            is Activity -> {
                androidId = Settings.Secure.getString(fragment.contentResolver, Settings.Secure.ANDROID_ID)
            }
            is Fragment -> {
                androidId = Settings.Secure.getString(
                    fragment.requireContext().contentResolver,
                    Settings.Secure.ANDROID_ID
                )
            }
        }
        Log.e("Android ID-Kt", androidId)

        if (!TextUtils.isEmpty(androidId)) {
            //todo 调用服务查询 androidId是否登录
            return true
        }
        return false

    }



}