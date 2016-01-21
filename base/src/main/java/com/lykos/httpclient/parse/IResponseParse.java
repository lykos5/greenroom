package com.lykos.httpclient.parse;

import org.apache.http.HttpEntity;

import java.io.IOException;

/**
 * response 解析接口
 * Created by Lykos on 16/1/21.
 */
public interface IResponseParse {
    Object parse(HttpEntity entity,String charset) throws IOException;
}
