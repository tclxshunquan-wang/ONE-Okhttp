package com.sampleokhttp.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

@Suppress("UNREACHABLE_CODE")
/**
 *==================================
 * Created by  on 2017/3/30.
 * @author shunq-wang
 *==================================
 */
class SampleInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain?.request()
        val t1 = System.nanoTime()
        Log.e("SampleOkHttp:",String.format("[发送请求] [%s] %s%n%s",
                request?.url(), chain?.connection(), request?.headers()))

        val response = chain?.proceed(request)

        val t2 = System.nanoTime()
        Log.e("SampleOkHttp:",String.format("[接收响应] [%s] %.1fms%n%s",
                response?.request()?.url(), (t2 - t1) / 1e6, response?.headers()))

        return response!!
    }
}