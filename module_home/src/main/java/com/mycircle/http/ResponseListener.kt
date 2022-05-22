package com.mycircle.http

interface ResponseListener<T> {
    fun onSuccess(data:T)
    fun onFail(err:String)
}