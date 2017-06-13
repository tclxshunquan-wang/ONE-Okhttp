package com.sampleokhttp.cache

import android.content.Context
import com.sampleokhttp.entity.UserInfo

/**
 *==================================
 * Created by  on 2017/5/12.
 * @author shunq-wang
 *==================================
 */
class ServiceCache{
    @JvmField var UserInfoCache:UserInfo?=null
    @JvmField var applicationContext:Context?=null
    companion object {
        @Synchronized fun getInstance(): ServiceCache =Inner.instance
    }
    private object Inner {
        val instance = ServiceCache()
    }
}