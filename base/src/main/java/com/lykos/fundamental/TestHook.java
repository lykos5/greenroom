package com.lykos.fundamental;

import java.util.Enumeration;

/**
 * Created by liujun on 16/12/2.
 */
public class TestHook {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new MyHook());
        //int i = 1/0;
        System.out.println(System.getProperty("user.dir"));
        Enumeration e = System.getProperties().keys();
        while(e.hasMoreElements()){
            Object o = e.nextElement();
            System.out.println(o+"="+System.getProperty(o.toString()));
        }


    }
}

class MyHook extends Thread{
    @Override
    public void run() {
        System.out.println("钩子关闭!");
    }
}