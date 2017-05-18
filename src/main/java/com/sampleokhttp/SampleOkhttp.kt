package com.sampleokhttp

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.sampleokhttp.entity.ResponseData
import com.sampleokhttp.entity.SampleMethod
import com.sampleokhttp.interceptor.SampleInterceptor
import com.sampleokhttp.request.SampleRequest
import com.sampleokhttp.utils.toMaps
import io.reactivex.ObservableEmitter
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 *==================================
 * Created by  on 2017/3/30.
 * @author shunq-wang
 *==================================
 */
class SampleOkhttp private constructor()  {
    var okhttpClient: OkHttpClient? = null
    var call: Call?=null
    var gson=GsonBuilder().create()
    companion object {
        @Synchronized fun getInstance(): SampleOkhttp =Inner.instance
    }
    private object Inner {
        val instance = SampleOkhttp()
    }

    init {
        okhttpClient = OkHttpClient().newBuilder()
                .addNetworkInterceptor(SampleInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)       //设置连接超时
                .readTimeout(30, TimeUnit.SECONDS)          //设置读超时
                .writeTimeout(30, TimeUnit.SECONDS)          //设置写超时
                .retryOnConnectionFailure(false)             //是否自动重连
                .build()

    }

    /**
     * 发送请求
     * @param tag 请求标示
     * @param url 请求路径
     * @param params 请求参数
     * @param typeToken 格式化数据类型
     * @param method 请求方法
     * @param handler
     * @return
     * **/
    fun <T> sendRequest(tag: Any, url: String, params:String,typeToken: TypeToken<T>, method: SampleMethod,emitter:ObservableEmitter<T>) {
        when (method) {
            SampleMethod.GET -> {
                call=okhttpClient?.newCall(Request.Builder().url(SampleRequest().GetRequest(url,toMaps(params))).tag(tag).build())
            }
            SampleMethod.POST -> {
                call=okhttpClient?.newCall(Request.Builder().url(url).post(SampleRequest().PostRequest(toMaps(params))).tag(tag).build())
            }
        }
        call!!.enqueue(object: Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                emitter.onError(e)
            }
            override fun onResponse(call: Call?, response: Response?) {
                emitter.onNext(parseResponseToEntity(response!!,typeToken))
                emitter.onComplete()
            }
        })
    }

    fun <T>parseResponseToEntity(response: Response,typeToken: TypeToken<T>):T{
        val result=response.body().string().toString()
        Log.e("SampleOkHttp:","[返回结果] $result".replace("\n",""))
        val t:T=gson.fromJson(result,typeToken.type)
        if(t is ResponseData<*>){
        }
        return t
    }
}
