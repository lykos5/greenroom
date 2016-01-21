package com.lykos.common.en;

/**
 *
 * 方法
 * Created by Lykos on 16/1/21.
 */
public enum HttpMethod {
    GET("GET"),POST("POST"),PUT("PUT"),DELETE("DELETE");
    private String method;
    private HttpMethod(String method){
        this.method = method;
    }
}
