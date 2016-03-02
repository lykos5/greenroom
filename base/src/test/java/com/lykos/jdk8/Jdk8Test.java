package com.lykos.jdk8;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lykos on 16/1/19.
 */
public class Jdk8Test {
    Logger logger = Logger.getLogger(Jdk8Test.class);
    org.slf4j.Logger logger2 = LoggerFactory.getLogger(Jdk8Test.class);
    List<String> stringList = Arrays.asList("a","b","c","d");
    @Test
    public void defaultMethod(){
        IDefaultMethod defaultMethod = ()->{
            System.out.println("实现say方法");
            logger.error("实现say方法");
            logger2.error("{6}he{}he",123);
        };
        defaultMethod.say();
        defaultMethod.sayHello();
        defaultMethod.sayHello2();
    }


    /**
     * 静态方法,,测试
     */
    @Test
    public void testStaticMethod(){
        stringList.forEach(System.out::println);
    }
}
