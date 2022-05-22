package com.mycircle.api

import retrofit2.http.GET

/**
 * Home模块的接口
 *
 * @author Qu Yunshuo
 * @since 6/4/21 5:51 PM
 */
interface HomeApiService {
    @GET("")
    fun login(phone: String, pwd: String)
}