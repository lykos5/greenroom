package com.lykos.pattern.observer.jdk;

import java.util.Observable;

/**
 * Created by Lykos on 16/3/4.
 */
public class Subject extends Observable {
    private String mes;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
        //当数据有变化时通知订阅者
        setChanged();
        notifyObservers();
    }
}
