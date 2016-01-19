package com.lykos.jdk8;

import org.junit.Test;

/**
 * Created by Lykos on 16/1/19.
 */
public class Jdk8Test {

    @Test
    public void defaultMethod(){
        IDefaultMethod defaultMethod = ()->{
            System.out.println("实现say方法");
        };
        defaultMethod.say();
        defaultMethod.sayHello();
    }
}
