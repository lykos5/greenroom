package com.lykos.pattern.factory;

import com.lykos.httpclient.HttpInvocationHander;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

/**
 *
 * 工厂类
 * Created by Lykos on 16/1/13.
 */
public class BeanFactory {

    private static Logger log = LoggerFactory.getLogger(BeanFactory.class);

    /**
     * 泛型方法的使用
     * 必须在返回值前边加一个<T>，来声明这是一个泛型方法，持有一个泛型T，然后才可以用泛型T作为方法的返回值。
     *     Class<T>的作用就是指明泛型的具体类型，而Class<T>类型的变量c，可以用来创建泛型类的对象
     * @param target
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> target){
        /**
         * 使用jdk8,新特性,函数式编程
         */
        return (T)Proxy.newProxyInstance(BeanFactory.class.getClassLoader(), new Class[]{target},(proxy,method,args)->{
            //method.invoke(this,args);
            return null;
        });
    }



    public static <T> T getHttpBean(Class<T> target){
        /**
         * 使用jdk8,新特性,函数式编程
         */
        return (T)Proxy.newProxyInstance(BeanFactory.class.getClassLoader(), new Class[]{target},new HttpInvocationHander());
    }





    /**
     * 创建类
     * @param objClass
     * @param <T>
     * @return
     */
    public static <T> T getInstance(Class<T> objClass){
        try {
            return objClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return null;
    }


}
