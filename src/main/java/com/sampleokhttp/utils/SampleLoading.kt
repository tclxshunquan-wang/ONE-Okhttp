package com.sampleokhttp.utils

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.sampleokhttp.R

/**
 *==================================
 * Created by  on 2017/5/5.
 * @author shunq-wang
 *==================================
 */

class SampleLoading(ctx: Context) : Dialog(ctx, R.style.CustomDialog) {
    var loadingView: View? = null


    init {
        loadingView = LayoutInflater.from(ctx).inflate(R.layout.loading, null)
        this.apply {
            setContentView(loadingView)
        }
    }

}