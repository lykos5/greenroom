package com.lykos.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Lykos on 16/3/4.
 */
public class Subscribe implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject)o;
        System.out.println(subject.getMes());
    }
}
