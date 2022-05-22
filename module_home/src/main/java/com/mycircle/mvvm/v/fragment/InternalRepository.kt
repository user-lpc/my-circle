//package com.mycircle.mvvm.v.fragment
//
//import com.mycircle.base.BaseRepository
//import kotlinx.coroutines.delay
//import javax.inject.Inject
//
///**
// * @author DBoy 2021/7/6 <p>
// * - 文件描述 :
// */
//class InternalRepository @Inject constructor() : BaseRepository() {
//
//    suspend fun getData() = request<String> {
//        delay(1000)
//        emit("数据加载成功")
//    }
//}