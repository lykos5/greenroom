package com.lykos.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Lykos on 16/1/14.
 */
public class TicketInvocationHander implements InvocationHandler {

    //被代理的目标对象
    private TicketSale ticketSale;

    public TicketInvocationHander(TicketSale ticketSale){
        super();
        this.ticketSale = ticketSale;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class objectClass = Object.class;//Object class
        Class methodDeclareClass = method.getDeclaringClass();//方法定义类
        if(objectClass==methodDeclareClass){//Object 的方法不做代理
            return method.invoke(ticketSale,args);
        }
        System.out.println(method.getName()+"---proxy"+proxy.toString()+"------------代理火车票开始object.class="+Object.class+"---DeclaringClass"+method.getDeclaringClass());
        Object o =  method.invoke(ticketSale,args);
        System.out.println(method.getName()+"------------代理火车票结束");
        return o;
    }
}
