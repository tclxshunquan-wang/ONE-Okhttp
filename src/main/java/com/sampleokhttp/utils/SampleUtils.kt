package com.sampleokhttp.utils

import java.lang.reflect.Field
import java.util.*

/**
 *==================================
 * Created by  on 2017/3/30.
 * @author shunq-wang
 *==================================
 */

@JvmField var SUCCESS=0x0001
@JvmField var FAIL=0x0002
fun toMaps(data: Any): LinkedHashMap<String, Any> {
    val map: LinkedHashMap<String, Any> = LinkedHashMap()
    val fields: Array<out Field> = data.javaClass.declaredFields
    for (field: Field in fields) {
        if (field.name.indexOf("kotlinClass") > 0) {
            continue
        }
        field.isAccessible = true
        if (field.get(data)!=null)
            map.put(field.name, field.get(data))
    }
    return map
}