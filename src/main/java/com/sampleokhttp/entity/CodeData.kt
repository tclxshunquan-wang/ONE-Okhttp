package com.sampleokhttp.entity

import java.io.Serializable

/**
 *==================================
 * Created by  on 2017/6/6.
 * @author shunq-wang
 *==================================
 */

/**
 * 所有开奖
 * "id":"1","name":"重庆时时彩","issue":"20170606-032","code":"5,3,4,9,9","status":"1"
 * **/
class AllCodeData:Serializable{
    var id:String?=null
    var name:String?=null
    var issue:String?=null
    var code:String?=null
    var status:String?=null
}
/**
 * 历史开奖
 * native_code":"6,6,9,1,8","code":"6,6,9,1,8","issue":"20170606-023","time":"01:55:49"
 * **/
class HistoryCodeData:Serializable{
    var native_code:String?=null
    var code:String?=null
    var issue:String?=null
    var time:String?=null
}