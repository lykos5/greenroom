package com.lykos.pattern.prototype;

import org.junit.Test;

/**
 * Created by Lykos on 16/3/3.
 */
public class PrototypeTest {


    @Test
    public void testPrototype(){
        PrototypeClassA prototypeClassA = new PrototypeClassA();
        prototypeClassA.setName("this.is prototypeClassA");
        prototypeClassA.setAge(18);
        PrototypeClassB prototypeClassB = new PrototypeClassB();
        prototypeClassB.setName("this is prototypeClassB");
        prototypeClassA.setPrototypeClassB(prototypeClassB);
        PrototypeClassA copyClass = (PrototypeClassA)prototypeClassA.clone();
        System.out.println(copyClass.getName()+" age is "+copyClass.getAge()+copyClass.getPrototypeClassB().getName());
        System.out.println("prototypeClassA:"+(prototypeClassA==copyClass));
        System.out.println("prototypeClassB:"+(prototypeClassB==copyClass.getPrototypeClassB()));
    }

}