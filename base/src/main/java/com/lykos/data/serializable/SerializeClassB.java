package com.lykos.data.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 *
 * 实现Externalizable自己实现序列化,在序列化之前之后多一些操作
 * Created by Lykos on 16/3/2.
 */
public class SerializeClassB implements Externalizable {

    private String name;
    private int age;
    private String sex;


    /////序列化必须存在一个无参构造方法
    public SerializeClassB(){}

    public SerializeClassB(String name,int age,String sex){
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
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(sex);
        out.writeInt(age);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readObject()+"external";
        sex = in.readObject()+"external";
        age = in.readInt();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
}
