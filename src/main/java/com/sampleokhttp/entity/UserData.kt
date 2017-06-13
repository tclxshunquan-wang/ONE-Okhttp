package com.sampleokhttp.entity

import java.io.Serializable

/**
 *==================================
 * Created by  on 2017/6/1.
 * @author shunq-wang
 *==================================
 */

/**
 * 用户实体
 *   @param  h_u_id: "46049",
 *   @param  h_u_gid: "10",
 *   @param  h_u_proxy_id: "28384",
 *   @param  h_u_proxy_list: "[\"admin\",\"admin1\",\"cb2018\",\"bufan12345\",\"luxian521\"]",
 *   @param  h_u_name: "damon78",
 *   @param  h_u_real_name: "",
 *   @param  h_u_login_count: 6,
 *   @param  h_u_max_rebate: "12.80",
 *   @param  h_u_current_rebate: "0.00",
 *   @param  h_u_same_rebate: "0.00",
 *   @param  h_u_balance: "0.0000",
 *   @param  h_u_frozen_balance: "0.0000",
 *   @param  h_u_dividends_balance: "0.0000",
 *   @param  h_u_is_lock_bank_info: "0",
 *   @param  h_u_is_withdraw: "1",
 *   @param  h_u_is_deposit: "1",
 *   @param  h_u_is_lower_transfer: "0",
 *   @param  h_u_is_lower_deposit: "0",
 *   @param  h_u_is_music: "1",
 *   @param  h_u_level: "0",
 *   @param  h_u_eredit_level: "0",
 *   @param  h_u_integral: "0",
 *   @param  h_u_experience: "0",
 *   @param  h_u_add_users: "[\"10\"]",
 *   @param  h_u_nickname: "damon",
 *   @param  h_u_email: "",
 *   @param  h_u_qq: "",
 *   @param  h_u_mobile: "",
 *   @param  h_u_reserved_info: "",
 *   @param  h_u_safety_qid: "0",
 *   @param  h_u_chat_avatar: "/static/model/users/img/system/logo.png",
 *   @param  h_u_chat_cid: "0",
 *   @param  h_u_chat_status: "0",
 *   @param  h_u_chat_signature: "这家伙很懒,什么都没留下.",
 *   @param  h_u_pt_username: "",
 *   @param   h_u_pt_balance: "0.00",
 *   @param  h_u_ag_username: "",
 *   @param   h_u_ag_balance: "0.00",
 *   @param  h_u_bbin_username: "",
 *   @param  h_u_bbin_balance: "0.00",
 *   @param  h_u_gg_username: "",
 *   @param  h_u_gg_balance: "0.00",
 *   @param  h_u_dj_username: "",
 *   @param  h_u_dj_balance: "0.00",
 *   @param  h_u_token: "1ba7a6d5e02ad4051a84cd74c2edf6a2",
 *   @param  h_u_sid: 1,
 *   @param  h_u_the_login_time: "2017-06-01 10:32:18",
 *   @param  h_u_the_login_ip: "180.173.55.159",
 *   @param  h_u_the_login_system: "未知操作系统",
 *   @param  h_u_last_login_time: "2017-06-01 10:14:40",
 *   @param  h_u_last_login_ip: "58.247.97.74",
 *   @param  h_u_last_login_system: "ios",
 *   @param  h_u_online_time: "2017-06-01 10:32:18",
 *   @param  h_u_regtime: "2017-06-01 10:10:59"
 *
 * **/
class UserInfo : Serializable {
    var h_u_id: String? = null
    var h_u_gid: String? = null
    var h_u_proxy_id: String? = null
    var h_u_proxy_list: String? = null
    var h_u_name: String? = null
    var h_u_real_name: String? = null
    var h_u_login_count: String? = null
    var h_u_max_rebate: String? = null
    var h_u_current_rebate: String? = null
    var h_u_same_rebate: String? = null
    var h_u_balance: String? = null
    var h_u_frozen_balance: String? = null
    var h_u_dividends_balance: String? = null
    var h_u_is_lock_bank_info: String? = null
    var h_u_is_withdraw: String? = null
    var h_u_is_deposit: String? = null
    var h_u_is_lower_transfer: String? = null
    var h_u_is_lower_deposit: String? = null
    var h_u_is_music: String? = null
    var h_u_level: String? = null
    var h_u_eredit_level: String? = null
    var h_u_integral: String? = null
    var h_u_experience: String? = null
    var h_u_add_users: String? = null
    var h_u_nickname: String? = null
    var h_u_email: String? = null
    var h_u_qq: String? = null
    var h_u_mobile: String? = null
    var h_u_reserved_info: String? = null
    var h_u_safety_qid: String? = null
    var h_u_chat_avatar: String? = null
    var h_u_chat_cid: String? = null
    var h_u_chat_status: String? = null
    var h_u_chat_signature: String? = null
    var h_u_pt_username: String? = null
    var h_u_pt_balance: String? = null
    var h_u_ag_username: String? = null
    var h_u_ag_balance: String? = null
    var h_u_bbin_username: String? = null
    var h_u_bbin_balance: String? = null
    var h_u_gg_username: String? = null
    var h_u_gg_balance: String? = null
    var h_u_dj_username: String? = null
    var h_u_dj_balance: String? = null
    var h_u_token: String? = null
    var h_u_sid: Int? = null
    var h_u_the_login_time: String? = null
    var h_u_the_login_ip: String? = null
    var h_u_the_login_system: String? = null
    var h_u_last_login_time: String? = null
    var h_u_last_login_ip: String? = null
    var h_u_last_login_system: String? = null
    var h_u_online_time: String? = null
    var h_u_regtime: String? = null
}