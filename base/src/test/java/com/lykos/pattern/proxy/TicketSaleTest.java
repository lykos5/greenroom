package com.lykos.pattern.proxy;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Lykos on 16/1/14.
 */
public class TicketSaleTest {

    @Test
    public void testSale() throws Exception{
        TicketSale ts = new TicketSale();
        InvocationHandler invocationHandler = new TicketInvocationHander(ts);
        //加载代理类信息
        Class proxyClass = Proxy.getProxyClass(TicketSaleTest.class.getClassLoader(),new Class[]{ITicketSale.class});
        //获取类的构造方法
        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
        ITicketSale tsProxy = (ITicketSale)constructor.newInstance(invocationHandler);
        //ITicketSale tsProxy = (ITicketSale)Proxy.newProxyInstance(TicketSale.class.getClassLoader(),new Class[]{ITicketSale.class},new TicketInvocationHander(ts));
        tsProxy.sale("");
        System.out.println(tsProxy);

    }

}