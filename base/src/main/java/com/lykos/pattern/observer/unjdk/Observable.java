package com.lykos.pattern.observer.unjdk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lykos on 16/3/4.
 */
public abstract class Observable {
    private List<IObserver> subscribes = new ArrayList<>();
    public void addObserver(IObserver observer){
        subscribes.add(observer);
    }

    public void removeObserver(IObserver observer){
        subscribes.remove(observer);
    }

    public void noticeObservers(){
        subscribes.forEach(m->m.update(this));
    }
}
