package com.mycircle.mvvm.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mycircle.base.ktx.launchIO
import com.mycircle.base.mvvm.vm.BaseViewModel
import com.mycircle.mvvm.m.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

/**
 * 首页的VM层
 *
 * @property mRepository HomeRepository 仓库层 通过Hilt注入
 *
 * @author Qu Yunshuo
 * @since 5/25/21 5:41 PM
 */
@HiltViewModel
class HomeViewModel @Inject constructor(private val mRepository: HomeRepository) : BaseViewModel() {

    val data = MutableLiveData<String>()

    /**
     * 模拟获取数据
     */
    fun getData() {
        launchIO {
            mRepository.getData()
                .catch { Log.d("qqq", "getData: $it") }
                .collect { data.postValue(it) }
        }
    }

}