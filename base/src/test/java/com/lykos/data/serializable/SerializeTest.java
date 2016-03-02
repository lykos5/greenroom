package com.lykos.data.serializable;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Lykos on 16/3/2.
 */
public class SerializeTest {


    String filename = "serializeObject.txt";
    SerializeClassA sca = new SerializeClassA("lykos",18,"man");
    SerializeClassB scaB = new SerializeClassB("lykos",18,"man");


    /**
     * 实现默认序列化
     * @throws Exception
     */
    @Test
    public void testSerializable() throws Exception{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("/Users/MLS/lykos/data/"+filename));
        System.out.println(sca.toString());
        outputStream.writeObject(sca);
        //////////////////////以上将对象序列化到磁盘上//////////////////////////
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/MLS/lykos/data/"+filename));
        SerializeClassA serializeClassA = (SerializeClassA)objectInputStream.readObject();
        System.out.println(serializeClassA.toString());
    }


    /**
     * 实现Externalizable
     * @throws Exception
     */
    @Test
    public void testExternalSerializable() throws Exception{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("/Users/MLS/lykos/data/"+filename));
        //System.out.println(scaB.toString());
        outputStream.writeObject(scaB);
        //////////////////////以上将对象序列化到磁盘上//////////////////////////
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/MLS/lykos/data/"+filename));
        SerializeClassB serializeClassB = (SerializeClassB)objectInputStream.readObject();
        System.out.println(serializeClassB);
    }

}