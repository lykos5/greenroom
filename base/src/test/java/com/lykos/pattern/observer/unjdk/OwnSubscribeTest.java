package com.lykos.pattern.observer.unjdk;

import org.junit.Test;

/**
 * Created by Lykos on 16/3/4.
 */
public class OwnSubscribeTest {

    @Test
    public void testSubscribe(){
        OwnSubject ownSubject = new OwnSubject();
        OwnSubscribe subscribe = new OwnSubscribe();
        ownSubject.addObserver(subscribe);
        ownSubject.setMes("hello own observer pattern");
    }

}