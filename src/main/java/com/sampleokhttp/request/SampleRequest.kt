package com.sampleokhttp.request

import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.File
import java.net.URLEncoder
import java.util.*
import kotlin.collections.HashMap

/**
 *==================================
 * Created by  on 2017/3/30.
 * @author shunq-wang
 *==================================
 */
class SampleRequest {

    val gson = GsonBuilder().create()

    /**
     * POST请求
     * @param params 请求参数 map
     * **/
    fun PostRequest(params: HashMap<String, String>): RequestBody {
        val Builder = FormBody.Builder()
        params.forEach { key, value ->
            Builder.add(key, value)
        }
        return Builder.build()
    }
    /**
     * GET请求
     * @param url  接口地址 string
     * @param params 请求参数 map
     * **/
    fun GetRequest(url:String,params: HashMap<String, String>?):String{
        val sb: StringBuffer = StringBuffer("")
        for ((key, value) in params!!) {
            if (value.isNotBlank())
                sb.append(key).append("=").append(URLEncoder.encode(value, "utf-8")).append("&")
        }
        if (sb.isNotEmpty()) sb.deleteCharAt(sb.length - 1)
        return url + "?" + sb.toString()
    }

    /**
     * 文件上传请求
     * @param params 请求参数 map
     * @return
     */
    private val FILE_TYPE = MediaType.parse("application/octet-stream")
    fun MultiPostRequest(params: LinkedHashMap<String, Any>?): RequestBody {
        val requestBody = MultipartBody.Builder()
        requestBody.setType(MultipartBody.FORM)
        if (params != null) {
            for ((key, value) in params) {
                if (value is File) {
                    requestBody.addPart(Headers.of("Content-Disposition", "form-data; name=\"$key\""),
                            RequestBody.create(FILE_TYPE, value))
                } else if (value is String) {
                    requestBody.addPart(Headers.of("Content-Disposition", "form-data; name=\"$key\""),
                            RequestBody.create(null, value))
                }
            }
        }
        return requestBody.build()
    }
}