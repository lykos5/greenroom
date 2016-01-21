package com.lykos.common.annotation;

import com.lykos.common.en.HttpMethod;
import com.lykos.httpclient.ContentType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

/**
 *
 * htttp 请求一般属性
 * Created by Lykos on 16/1/21.
 */
@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HttpParam {
    String value() default "";//具体请求地址
    HttpMethod method() default HttpMethod.GET;//请求方式
    ContentType contentType() default ContentType.APPLICATION_JSON;//请求类型
    String charset() default  "UTF-8";//编码
    String[] headers() default {};//header数据
}
