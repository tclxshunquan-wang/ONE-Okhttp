package com.sampleokhttp.entity

import java.io.Serializable

/**
 *==================================
 * Created by  on 2017/6/2.
 * @author shunq-wang
 *==================================
 */
class ConfigBanner : Serializable {
    var img:String?=null
    var model:String?=null
}

class MainPlay:Serializable{
    var h_g_n_id:String?=null
    var h_g_n_cid:String?=null
    var h_g_n_title:String?=null
    var h_g_n_is_hot:String?=null
    var h_g_n_off:String?=null
    var h_g_n_show:String?=null
    var h_g_n_is_new:String?=null
    var h_g_n_win_rules:String?=null
    var isAdd:Boolean?=false
}

class MainPlayType:Serializable{
    var h_g_c_id:String?=null
    var h_g_c_name:String?=null
    var h_g_c_off:String?=null
    var h_g_c_show:String?=null
}