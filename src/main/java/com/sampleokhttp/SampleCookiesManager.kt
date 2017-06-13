package com.sampleokhttp

import com.sampleokhttp.cache.ServiceCache
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

/**
 *==================================
 * Created by  on 2017/6/2.
 * @author shunq-wang
 *==================================
 */
class SampleCookiesManager:CookieJar{
     val store = PersistentCookieStore(ServiceCache.getInstance().applicationContext!!)

    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>?) {
        store[url.host()] = cookies!!
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        return store[url.host()] ?: ArrayList<Cookie>()
    }
}