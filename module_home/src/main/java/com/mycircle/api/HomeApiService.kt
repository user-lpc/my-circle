package com.mycircle.api

import com.mycircle.pojo.TopNew
import retrofit2.http.GET

/**
 * Home模块的接口
 *
 */


interface HomeApiService {
    @GET("/")
    fun login(phone: String, pwd: String)

    @GET("news/techblogs/demo")
    suspend fun getTest():TopNew
}