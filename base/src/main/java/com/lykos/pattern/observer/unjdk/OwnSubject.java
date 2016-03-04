package com.lykos.pattern.observer.unjdk;

/**
 * Created by Lykos on 16/3/4.
 */
public class OwnSubject extends Observable {

    private String mes;



    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
        noticeObservers();
    }
}
