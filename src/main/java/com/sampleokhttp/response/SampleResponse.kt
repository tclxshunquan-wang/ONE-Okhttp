package com.sampleokhttp.response

import okhttp3.MediaType
import okhttp3.ResponseBody
import okio.BufferedSource

/**
 *==================================
 * Created by  on 2017/3/30.
 * @author shunq-wang
 *==================================
 */
class SampleResponse:ResponseBody(){
    override fun contentLength(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun contentType(): MediaType {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun source(): BufferedSource {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}