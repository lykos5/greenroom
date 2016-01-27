package com.lykos.mvcapi.common;

import java.io.Serializable;

/**
 * Created by Lykos on 16/1/27.
 */
public class ResponseResult implements Serializable{

    private boolean suc;
    private String code;
    private String message;
    private Object data;

    public boolean isSuc() {
        return suc;
    }

    public void setSuc(boolean suc) {
        this.suc = suc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
