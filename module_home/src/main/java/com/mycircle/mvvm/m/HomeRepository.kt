package com.mycircle.mvvm.m

import com.mycircle.base.mvvm.m.BaseRepository
import com.mycircle.api.HomeApiService
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 * 首页M层
 *
 */
class HomeRepository @Inject constructor() : BaseRepository() {

    @Inject
    lateinit var mApi: HomeApiService

    /**
     * 模拟获取数据
     */
    suspend fun getData() = request<String> {
        delay(1000L)
        emit("Hello Hilt")
    }

    fun login(phone: String, pwd: String) {
        mApi.login(phone,pwd)
    }
}