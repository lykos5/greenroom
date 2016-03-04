package com.lykos.pattern.observer.jdk;

import org.junit.Test;

/**
 * Created by Lykos on 16/3/4.
 */
public class ObserverTest {

    @Test
    public void testSubscribe(){
        Subject subject = new Subject();
        Subscribe subscribe = new Subscribe();
        subject.addObserver(subscribe);
        subject.setMes("hello observer pattern");
    }

}