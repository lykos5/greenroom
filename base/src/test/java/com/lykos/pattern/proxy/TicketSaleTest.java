package com.lykos.pattern.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by Lykos on 16/1/14.
 */
public class TicketSaleTest {

    @Test
    public void testSale(){
        TicketSale ts = new TicketSale();
        ITicketSale tsProxy = (ITicketSale)Proxy.newProxyInstance(TicketSale.class.getClassLoader(),new Class[]{ITicketSale.class},new TicketInvocationHander(ts));
        tsProxy.sale("");

    }

}