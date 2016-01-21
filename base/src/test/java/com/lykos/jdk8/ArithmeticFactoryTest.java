package com.lykos.jdk8;

import com.lykos.common.po.People;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lykos on 16/1/18.
 */
public class ArithmeticFactoryTest {

    static List<People> peoples = null;

    static{
        People p1 = new People();
        p1.setAge(30);

        People p2 = new People();
        p2.setAge(20);

        People p3 = new People();
        p3.setAge(20);
        peoples = Arrays.asList(p1,p2,p3);
    }


    @Test
    public void compare(){
        System.out.println(ArithmeticFactory.age().compare(peoples.get(0),peoples.get(1)));
    }


    @Test
    public void filter(){
        ArithmeticFactory.age(20).filter(peoples).stream().forEach(x-> System.out.println(x.getAge()));
        System.out.println(peoples.size());
    }

    @Test
    public void convert(){
        System.out.println(ArithmeticFactory.convert(peoples));
    }



}