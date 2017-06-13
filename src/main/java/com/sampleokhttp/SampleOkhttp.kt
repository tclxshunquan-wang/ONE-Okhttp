package com.sampleokhttp

import android.content.Context
import android.content.Intent
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
import android.webkit.WebSettings
import android.os.Build
import android.os.Bundle


/**
 *==================================
 * Created by  on 2017/3/30.
 * @author shunq-wang
 *==================================
 */
class SampleOkhttp private constructor() {
    var okhttpClient: OkHttpClient? = null
    var call: Call? = null
    var gson = GsonBuilder().create()
    var context:Context?=null

    companion object {
        @Synchronized fun getInstance(): SampleOkhttp {
            return  Inner.instance
        }
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
                .cookieJar(SampleCookiesManager())           //持久化存储
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
    fun <T> sendRequest( ctx: Context, tag: Any, url: String, params: HashMap<String, String>, typeToken: TypeToken<T>, method: SampleMethod, emitter: ObservableEmitter<T>) {
        when (method) {
            SampleMethod.GET -> {
                call = okhttpClient?.newCall(Request.Builder().url(SampleRequest().GetRequest(url, params)).tag(tag).removeHeader("User-Agent").addHeader("User-Agent",getUserAgent(ctx)).build())
            }
            SampleMethod.POST -> {
                call = okhttpClient?.newCall(Request.Builder().url(url).post(SampleRequest().PostRequest(params)).tag(tag).build())
            }
        }
        call!!.enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                emitter.onError(e)
            }

            override fun onResponse(call: Call?, response: Response?) {
                emitter.onNext(parseResponseToEntity(ctx ,response!!, typeToken))
                emitter.onComplete()
            }
        })
    }

    private fun getUserAgent(ctx: Context): String {
        var userAgent = ""
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            try {
                userAgent = WebSettings.getDefaultUserAgent(ctx)
            } catch (e: Exception) {
                userAgent = System.getProperty("http.agent")
            }

        } else {
            userAgent = System.getProperty("http.agent")
        }
        val sb = StringBuffer()
        var i = 0
        val length = userAgent.length
        while (i < length) {
            val c = userAgent[i]
            if (c <= '\u001f' || c >= '\u007f') {
                sb.append(String.format("\\u%04x", c.toInt()))
            } else {
                sb.append(c)
            }
            i++
        }
        return sb.toString()
    }


    fun <T> parseResponseToEntity(ctx: Context,response: Response, typeToken: TypeToken<T>): T? {
        val result = response.body().string().toString()
        Log.e("SampleOkHttp:", "[返回结果] $result".replace("\n", ""))
        try {

            if (result.trim().contains("\"error\"")) {
                val t: ResponseData<Any> = gson.fromJson(result, object:TypeToken<ResponseData<Any>>(){}.type)
                if(t.data.toString().contains("登陆超时或未登陆,请先登陆")){
                    ctx.sendBroadcast(Intent().apply {
                        action = "com.planage.missed"
                    })
                }
                return ResponseData(t.error,null) as T
            } else {
                val t: T = gson.fromJson(result, typeToken.type)
//            if (t is ResponseData<*>) {
//            }
                return t
            }
        } catch (e: IllegalStateException) {
            Log.e("SampleOkHttp:", "[返回结果] data类型不合法")
        } catch (e: Exception) {
            Log.e("SampleOkHttp:", "[返回结果] ${e.printStackTrace()}")
        }
        return null
    }
}
