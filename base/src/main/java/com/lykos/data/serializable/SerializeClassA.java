package com.lykos.data.serializable;

import java.io.Serializable;

/**
 *
 * 序列化对象实现Serializable没有实现任何方法,调用jdk默认序列化方法
 * Created by Lykos on 16/3/2.
 */
public class SerializeClassA implements Serializable{
    private String name;
    private int age;
    private transient String sex;//sex不会被序列化,因为用关键字transient修饰过

    /////序列化必须存在一个无参构造方法
    public SerializeClassA(){}

    public SerializeClassA(String name,int age,String sex){
        this.age = age;
        this.name = name;
        this.sex = sex;
    }


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


    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass()+"\n");
        sb.append("name="+(this.getName()==null?"":this.getName())+"\n");
        sb.append("sex="+(this.getSex()==null?"":this.getSex())+"\n");
        sb.append("age="+this.getAge());
        return sb.toString();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
