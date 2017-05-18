package com.sampleokhttp

import android.content.Context
import com.google.gson.reflect.TypeToken
import com.sampleokhttp.callback.SampleCallback
import com.sampleokhttp.entity.SampleMethod
import com.sampleokhttp.utils.SampleLoading
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import okhttp3.Call

/**
 *==================================
 * Created by  on 2017/5/5.
 * @author shunq-wang
 *==================================
 */
class SampleRxRequest<T>(ctx: Context, val tag: Any, val url: String, val params: String, val method: SampleMethod) {

    var sampleOkhttp: SampleOkhttp = SampleOkhttp.getInstance()
    var observable: Observable<T>? = null
    var observer: Observer<T>? = null
    var loading: SampleLoading? = SampleLoading(ctx)

    fun rxRequest(typeToken: TypeToken<T>,rxCallBack:SampleCallback<T>) {
        show()
        observable = Observable.create { e ->
            sampleOkhttp.sendRequest(tag, url, params, typeToken, method, e!!)
        }

        observer = object : Observer<T> {
            override fun onError(e: Throwable?) {
                try {
                    dismiss()
                    rxCallBack.onFailure(e)
                }catch (e:Exception){
                }
            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(t: T) {
                rxCallBack.onSuccess(t)
            }

            override fun onComplete() {
                dismiss()
                cancelOneQueue(tag)
            }
        }
        observable?.observeOn(AndroidSchedulers.mainThread())?.filter { it != null }?.subscribe(observer)

    }

    /**
     * 取消全部请求
     * **/
    fun cancelAll() {
        sampleOkhttp.okhttpClient?.dispatcher()?.cancelAll()

    }

    /**
     * 取消队列中指定tag的请求
     * @param tag
     * **/
    fun cancelOneQueue(tag: Any) {
        sampleOkhttp.okhttpClient?.dispatcher()?.queuedCalls()?.filter { tag == it.request().tag() }?.forEach(Call::cancel)
    }

    /**
     * 取消正在执行中的指定tag的请求
     * @param tag
     * **/
    fun cancelOneRunning(tag: Any) {
        sampleOkhttp.okhttpClient?.dispatcher()?.runningCalls()?.filter { tag == it.request().tag() }?.forEach(Call::cancel)
    }

    /**
     * 显示loading
     * **/
    fun show() {
        if (loading != null) {
            loading?.show()
        }
    }

    /**
     * 隐藏loading
     * **/
    fun dismiss() {
        if (loading != null && loading!!.isShowing) {
            loading?.dismiss()
        }
    }

}