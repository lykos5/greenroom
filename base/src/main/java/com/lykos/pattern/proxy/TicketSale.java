package com.lykos.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * 被代理对象,销售火车票
 * Created by Lykos on 16/1/14.
 */
public class TicketSale implements ITicketSale{
    @Override
    public String sale(String ticket) {
        System.out.println("卖票");
        return null;
    }


    public static void main(String [] args){
        TicketSale ts = new TicketSale();
        ITicketSale tsProxy = (ITicketSale) Proxy.newProxyInstance(TicketSale.class.getClassLoader(),new Class[]{ITicketSale.class},new TicketInvocationHander(ts));
        tsProxy.sale("");
    }
}
