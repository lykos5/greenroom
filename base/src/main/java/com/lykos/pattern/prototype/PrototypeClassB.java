package com.lykos.pattern.prototype;

/**
 * Created by Lykos on 16/3/3.
 */
public class PrototypeClassB implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Object clone(){
        PrototypeClassB prototypeClassB = null;
        try {
            prototypeClassB = (PrototypeClassB)super.clone();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return prototypeClassB;
    }
}
