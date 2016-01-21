package com.lykos.httpclient;

import com.lykos.common.annotation.BaseUrl;
import com.lykos.common.annotation.HttpParam;
import com.lykos.common.en.HttpMethod;

import java.util.Map;

/**
 * 请求接口
 * Created by Lykos on 16/1/13.
 */
@BaseUrl("http://test.gd.meilishuo.com:8080")
public interface IHttpUrl {
    @HttpParam("index/code/details")
    Map get();

    @HttpParam(value = "login/login",method = HttpMethod.POST,contentType = ContentType.FORM_URLENCODED)
    Map login(Map map);
}
