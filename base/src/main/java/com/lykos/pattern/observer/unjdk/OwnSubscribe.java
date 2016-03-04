package com.lykos.pattern.observer.unjdk;

/**
 * Created by Lykos on 16/3/4.
 */
public class OwnSubscribe implements IObserver {
    @Override
    public void update(Observable observable) {
        OwnSubject subject = (OwnSubject)observable;
        System.out.println(subject.getMes());
    }
}
