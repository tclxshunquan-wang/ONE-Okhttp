package com.sampleokhttp.entity

import java.io.Serializable

/**
 *==================================
 * Created by  on 2017/5/31.
 * @author shunq-wang
 *==================================
 */
/**
 *
 * @param h_n_id	      自动编号
 * @param h_n_title		  公告标题
 * @param h_n_admin	      哪个管理员发布的
 * @param h_n_is_show     是否显示
 * @param h_n_text		  公告内容
 * @param h_n_read_count  阅读次数
 * @param h_n_addtime	  添加时间
 * **/
class NoticeData:Serializable{
    var h_n_id:String?=null
    var h_n_title:String?=null
    var h_n_admin:String?=null
    var h_n_is_show:String?=null
    var h_n_text:String?=null
    var h_n_read_count:String?=null
    var h_n_addtime:String?=null
}

class NoticeList:Serializable{
    var total_pages:Int?=null
    var current_page:String?=null
    var count:String?=null
    var list:ArrayList<NoticeData>?=null
}