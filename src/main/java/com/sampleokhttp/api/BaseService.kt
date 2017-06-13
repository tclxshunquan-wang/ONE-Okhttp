package com.sampleokhttp.api

import java.util.*


/**
 *==================================
 * Created by  on 2017/5/31.
 * @author shunq-wang
 *==================================
 */
open class BaseService{


    fun getBaseParams(): HashMap<String, String> {
        return HashMap<String,String>().apply {
//            putAll(mapOf(Pair("token",ServiceCache.getInstance().UserInfoCache?.h_u_token!!)))
        }
    }
}