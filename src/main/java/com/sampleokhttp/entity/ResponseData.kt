package com.sampleokhttp.entity

/**
 *==================================
 * Created by  on 2017/3/31.
 * @author shunq-wang
 *==================================
 */
data class ResponseData<T>(
        var error:String?=null,
        var data:T?=null
)
