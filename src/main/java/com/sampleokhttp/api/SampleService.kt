package com.sampleokhttp.api

import android.content.Context
import com.google.gson.reflect.TypeToken
import com.sampleokhttp.SampleRxRequest
import com.sampleokhttp.callback.SampleCallback
import com.sampleokhttp.entity.Data
import com.sampleokhttp.entity.SampleMethod

/**
 *==================================
 * Created by  on 2017/5/5.
 * @author shunq-wang
 *==================================
 */
class SampleService(var ctx:Context){


    fun getName(callback:SampleCallback<Data>){
        val url="http://japi.juhe.cn/joke/content/list.from"
        val type = object : TypeToken<Data>() {}
        SampleRxRequest<Data>(ctx, ctx, url, "", SampleMethod.GET).rxRequest(type,callback)
    }
}