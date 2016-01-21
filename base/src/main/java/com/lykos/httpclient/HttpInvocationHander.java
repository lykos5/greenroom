package com.lykos.httpclient;

import com.lykos.common.annotation.BaseUrl;
import com.lykos.common.annotation.HttpParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * http 请求
 * Created by Lykos on 16/1/21.
 */
public class HttpInvocationHander implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class declaringClass = method.getDeclaringClass();
        HttpParam httpParam = null;
        String baseUrl = "";
        if(Object.class==declaringClass){/////object方法不做代理
            return method.invoke(args);
        }
        Annotation[] types = declaringClass.getAnnotations();
        if(types!=null && types.length>0){
            baseUrl = ((BaseUrl)types[0]).value();
        }
        Annotation[] methods = method.getAnnotations();
        if(methods!=null && methods.length>0){
            httpParam = (HttpParam)methods[0];
        }
        return HttpUtil.execute(baseUrl,httpParam,args[0]);
    }
}
