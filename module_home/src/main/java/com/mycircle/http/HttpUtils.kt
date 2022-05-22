package com.mycircle.http

import com.mycircle.constants.HttpTest.BASE_URL
import com.mycircle.constants.HttpTest.BASE_URL_TEST
import com.orhanobut.logger.Logger
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object HttpUtils {

    private fun isTest(isTest: Boolean) = if (isTest) BASE_URL_TEST else BASE_URL

    private var mOkHttpClient: OkHttpClient? = null

    fun <T> createApi(clazz: Class<T>): T = Retrofit.Builder()
        .baseUrl(isTest(true))
        .client(getClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(clazz)

    private fun getClient(): OkHttpClient {
        if (mOkHttpClient == null) {
            mOkHttpClient = OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .retryOnConnectionFailure(true)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
        }
        return mOkHttpClient as OkHttpClient
    }

    private fun getInterceptor(): Interceptor {
        HttpLoggingInterceptor.Logger {
            Logger.json(it)
        }
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    fun <T> sendHttp(ob: Observable<T>, listener: ResponseListener<T>) {
        ob.subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<T> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: T) {
                    listener.onSuccess(t)
                }

                override fun onError(e: Throwable) {
                    listener.onFail(e.message.toString())
                }

            })
    }
}
