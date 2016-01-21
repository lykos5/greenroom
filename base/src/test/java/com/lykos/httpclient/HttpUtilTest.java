package com.lykos.httpclient;

import com.google.common.collect.ImmutableMap;
import com.lykos.pattern.factory.BeanFactory;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Lykos on 16/1/21.
 */
public class HttpUtilTest {

    @Test
    public void get(){
        IHttpUrl httpUrl = BeanFactory.getHttpBean(IHttpUrl.class);
        Map map = httpUrl.get();
        System.out.println();
    }


    @Test
    public void login(){
        IHttpUrl httpUrl = BeanFactory.getHttpBean(IHttpUrl.class);
        Map map = httpUrl.login(ImmutableMap.of("content","{}"));
        System.out.println();
    }

}