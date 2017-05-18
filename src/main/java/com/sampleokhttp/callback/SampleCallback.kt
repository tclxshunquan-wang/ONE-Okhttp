package com.sampleokhttp.callback

/**
 *==================================
 * Created by  on 2017/3/30.
 * @author shunq-wang
 *==================================
 */
interface  SampleCallback<in T>{

     fun onFailure( e: Throwable?)

     fun onSuccess(t:T)
}
