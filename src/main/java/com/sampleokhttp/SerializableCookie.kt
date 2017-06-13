package com.sampleokhttp

import okhttp3.Cookie
import java.io.Serializable

/**
 *==================================
 * Created by  on 2017/6/2.
 * 序列化的Cookie对象
 * @author cxm
 * @author shunq-wang
 *==================================
 */
class SerializableCookie(cookie: Cookie):Serializable{
    private val name: String? = cookie.name()
    private val value: String? = cookie.value()
    private val expiresAt: Long?= cookie.expiresAt()
    private val domain: String?= cookie.domain()
    private val path: String?= cookie.path()
    private val secure: Boolean?= cookie.secure()
    private val httpOnly: Boolean?= cookie.httpOnly()
    private val hostOnly: Boolean?= cookie.hostOnly()

    /**
     * 从当前对象中参数生成一个Cookie
     * @author cxm
     */
    fun cookie(): Cookie {
        return Cookie.Builder()
                .name(name)
                .value(value)
                .expiresAt(expiresAt ?: 0L)
                .path(path)
                .let {
                    if (secure ?: false) it.secure()
                    if (httpOnly ?: false) it.httpOnly()
                    if (hostOnly ?: false)
                        it.hostOnlyDomain(domain)
                    else
                        it.domain(domain)
                    it
                }
                .build()
    }
}