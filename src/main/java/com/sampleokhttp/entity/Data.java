package com.sampleokhttp.entity;

import java.util.List;

/**
 * ==================================
 * Created by  on 2017/5/5.
 *
 * @author shunq-wang
 *         ==================================
 */

public class Data {
    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    String resultcode;
    String reason;
    List<String> result;
    int error_code;
}
