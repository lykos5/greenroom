package com.lykos.jdk8;

/**
 *
 * @FunctionalInterface  注明为函数式接口
 * Created by Lykos on 16/1/19.
 */
@FunctionalInterface
public interface IDefaultMethod {
    void say();
    default void sayHello(){
        System.out.println("接口可以定义多个默认方法,实现此接口的子类,默认拥有这个方法");
    }
    default void sayHello2(){
        System.out.println("接口可以定义多个默认方法,实现此接口的子类,默认拥有这个方法");
    }
}
