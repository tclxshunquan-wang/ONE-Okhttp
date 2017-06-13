package com.sampleokhttp.cache

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import java.io.Serializable

/**
 *==================================
 * Created by  on 2017/5/12.
 * @author shunq-wang
 *==================================
 */
class SPUtils {

    companion object {
        private val TAG = javaClass.simpleName
        const val UserInfo = "UserInfo"
        const val STATISTICS_DATA = "Invidaildata"//初始化状态
        const val BASE_PARAMS_FILE = "BaseTags"//基础参数
        const val TAG_LOGIN = "loginTag"//登陆状态
        const val TAG_LOGIN_ING = "loginTagIng"//登陆状态
        const val BASE_CONFIG = "BaseConfig"//我的设置

        /**
         * 从本地存储中获取数据（对象）
         */
        fun <T> getSerData(context: Context, clazz: Class<T>, name: String?, key: String?): T {
            var t: T? = null
            try {
                t = clazz.newInstance()
                val fileName = name ?: BASE_PARAMS_FILE
                val sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
                val files = clazz.declaredFields
                for (field in files) {
                    if (field.name.indexOf("kotlinClass") > 0) {
                        continue
                    }
                    field.isAccessible = true
                    if (key == null || key == field.name) {
                        if (field.genericType == String::class.java)
                            field.set(t, sp.getString(field.name, ""))
                        if (field.genericType == Integer::class.java)
                            field.set(t, sp.getInt(field.name, 0))
                        if (field.genericType == Int::class.java)
                            field.set(t, sp.getInt(field.name, 0))
                        if (field.genericType == Float::class.java)
                            field.set(t, sp.getFloat(field.name, 0f))
                        if (field.genericType == Long::class.java)
                            field.set(t, sp.getLong(field.name, 0L))
                        if (field.genericType == Boolean::class.java)
                            field.set(t, sp.getBoolean(field.name, false))
                    }
                }
            } catch(e: Exception) {
                Log.e(TAG, "SPUtil.getSerData error:${e.message}", e)
            }
            return t!!
        }

        fun clear(context: Context, name: String) {
            val sp = context.getSharedPreferences(name, Context.MODE_PRIVATE)
            sp.edit().clear().commit()
        }

        /**
         * 将对象存储到SharedPreferences
         */
        fun saveSerData(context: Context, data: Serializable, name: String): Boolean {
            val sp = context.getSharedPreferences(name, Context.MODE_PRIVATE)
            return fillEditor(sp, data).commit()
        }

        private fun fillEditor(sp: SharedPreferences, ser: Serializable): SharedPreferences.Editor {
            val editor = sp.edit()
            val fields = ser.javaClass.declaredFields
            try {
                for (field in fields) {
                    if (field.name.indexOf("kotlinClass") > 0 || field.name == "Args") continue
                    field.isAccessible = true
                    val obj = field.get(ser)
                    obj ?: continue
                    if (obj is String) editor.putString(field.name, obj.toString())
                    if (obj is Int) editor.putInt(field.name, obj.toInt())
                    if (obj is Float) editor.putFloat(field.name, obj.toFloat())
                    if (obj is Boolean) editor.putBoolean(field.name, obj)
                    if (obj is Long) editor.putLong(field.name, obj.toLong())
                }
            } catch(e: Exception) {
                Log.e(TAG!!, "SPUtil.getSerData error:${e.message}", e)
            }
            return editor
        }

        fun saveInt(context: Context, key: String, value: Int = 0): Boolean {
            val sharedPreferences = context.getSharedPreferences("sample_retail", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putInt(key, value)
            return editor.commit()
        }

        fun getInt(context: Context, key: String, default: Int = 0): Int {
            val sharedPreferences = context.getSharedPreferences("sample_retail", Context.MODE_PRIVATE)
            return sharedPreferences.getInt(key, default)
        }

        fun saveString(context: Context, key: String, value: String? = "", fileName: String = SPUtils.STATISTICS_DATA): Boolean {
            val sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(key, value)
            return editor.commit()
        }

        fun getCacheString(context: Context, key: String, fileName: String = SPUtils.STATISTICS_DATA): String {
            val sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
            return sharedPreferences.getString(key, "")
        }

        fun saveLong(context: Context, name: String, value: Long?): Boolean {
            val sharedPreferences = context.getSharedPreferences("sample_retail", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putLong(name, value!!)
            return editor.commit()
        }

        fun getLong(context: Context, name: String): Long {
            val sharedPreferences = context.getSharedPreferences("sample_retail", Context.MODE_PRIVATE)
            val value = sharedPreferences.getLong(name, 0)
            return value
        }

        fun getBoolean(context: Context, name: String, fName: String, default: Boolean = true): Boolean {
            val sharedPreferences = context.getSharedPreferences(fName, Context.MODE_PRIVATE)
            val value = sharedPreferences.getBoolean(name, default)
            return value
        }

        fun saveBoolean(context: Context, name: String, fName: String, value: Boolean = true): Boolean {
            val sharedPreperences = context.getSharedPreferences(fName, Context.MODE_PRIVATE)
            val editor = sharedPreperences.edit()
            editor.putBoolean(name, value)
            return editor.commit()
        }
    }
}