package com.lykos.pattern.prototype;

/**
 * Created by Lykos on 16/3/3.
 */
public class PrototypeClassA implements Cloneable {
    private String name;
    private int age;
    private PrototypeClassB prototypeClassB;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PrototypeClassB getPrototypeClassB() {
        return prototypeClassB;
    }

    public void setPrototypeClassB(PrototypeClassB prototypeClassB) {
        this.prototypeClassB = prototypeClassB;
    }


    /**
     * 主要是实现clone方法
     * @return
     */
    @Override
    public Object clone(){
        PrototypeClassA prototypeClassA = null;
        try {
            prototypeClassA = (PrototypeClassA)super.clone();
            PrototypeClassB prototypeClassB = (PrototypeClassB)this.prototypeClassB.clone();
            prototypeClassA.setPrototypeClassB(prototypeClassB);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return prototypeClassA;
    }
}
