package com.mycircle.mvvm.vm

import android.text.Editable
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mycircle.base.ktx.launchIO
import com.mycircle.base.mvvm.vm.BaseViewModel
import com.mycircle.mvvm.m.LoginRepository
import com.mycircle.pojo.TopNew
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

/**
 * 登录页的VM层
 *
 * @property mRepository LoginRepository 仓库层 通过Hilt注入
 */
@HiltViewModel
class LoginViewModel @Inject constructor(private val mRepository: LoginRepository) :
    BaseViewModel() {

    val dataString = MutableLiveData<String>()
    val data = MutableLiveData<TopNew>()

    /**
     * 模拟获取数据
     */
    fun getData() {
        launchIO {
            mRepository.getData()
                .catch { Log.d("qqq", "getData: $it") }
                .collect { dataString.postValue(it) }
        }
    }

    /**
     * 调用接口服务
     */
    fun getTest() {
        launchIO {
            mRepository.getTest().catch { Log.d("qqq", "getData: $it") }
                .collect { data.postValue(it) }
        }

    }

    fun login(phone: Editable?, pwd: Editable?): Boolean {
        return false
    }

}