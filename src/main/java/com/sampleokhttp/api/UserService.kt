package com.sampleokhttp.api

import android.content.Context
import android.util.Pair
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sampleokhttp.SampleRxRequest
import com.sampleokhttp.callback.SampleCallback
import com.sampleokhttp.entity.Data
import com.sampleokhttp.entity.ResponseData
import com.sampleokhttp.entity.SampleMethod
import com.sampleokhttp.entity.UserInfo
import com.sampleokhttp.cache.Constant
import java.util.*

/**
 *==================================
 * Created by  on 2017/5/31.
 * @author shunq-wang
 *==================================
 */
class UserService(var ctx: Context):BaseService(){

    /**
     * 退出登陆
     * 无参数
     * @return
     * **/
    fun isMobile(callback: SampleCallback<ResponseData<Any>>){
        val url="${Constant.BASE_URL}mobile/is_mobile"
        val type = object : TypeToken<ResponseData<Any>>() {}
        SampleRxRequest<ResponseData<Any>>(ctx, ctx, url, HashMap(), SampleMethod.GET).rxRequest(type,callback)
    }

    /**
     * 退出登陆
     * 无参数
     * @return
     * **/
    fun loginOut(callback: SampleCallback<Data>){
        val url="${Constant.BASE_URL}mobile/sign_out"
        val type = object : TypeToken<Data>() {}
        SampleRxRequest<Data>(ctx, ctx, url, HashMap(), SampleMethod.GET).rxRequest(type,callback)
    }
    /**
     * 登陆
     * @param username 会员账号
     * @param password 会员登陆密码
     * @return
     * **/
    fun login(username:String,password:String,callback: SampleCallback<ResponseData<UserInfo>>){
        val url="${Constant.BASE_URL}mobile/login"
        val type = object : TypeToken<ResponseData<UserInfo>>() {}
        val params=mapOf(Pair("username",username),Pair("password",password)) as HashMap
        SampleRxRequest<ResponseData<UserInfo>>(ctx, ctx, url,params, SampleMethod.GET).rxRequest(type,callback)
    }

}