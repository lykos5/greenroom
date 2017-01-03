package com.lykos.io;

import java.io.*;
import java.util.Arrays;

/**
 * Created by liujun on 16/11/30.
 */
public class IOTest {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/liujun/log/kindbrother/history.log") ;
        InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        Reader reader = new FileReader(file);
        byte [] bytes = new byte[20];
        int size = is.read(bytes);
        System.out.println(size);
        System.out.println("--------------------");
        System.out.println(is.available());
        for(byte b : bytes){
            System.out.println(b);
        }
        bytes = new byte[20];
        char[] ch = new char[10];
        size = reader.read(ch);
        System.out.println(size);
        System.out.println(".........................");
        for(char m : ch){
            System.out.println(m);
        }
    }
}
