package com.lykos.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by liujun on 16/8/31.
 */
public class CollectionDemo {
    public static void main(String[] args) {
        //Arrays.asList() 创建不可变集合
        List list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,4,5,6,7,8));
        //拷贝一份不可变集合
        List immutableLists = ImmutableList.copyOf(list);
        list.stream().forEach(System.out::print);
        list.add(9);
        list.stream().forEach(System.out::print);
        immutableLists.stream().forEach(System.out::print);
        try {
            immutableLists.add(9);
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("不可变集合测试");
        }
        immutableLists.stream().forEach(System.out::print);
        //创建不可变map
        Map map = ImmutableMap.of("k1","value1","k2","v2");
        System.out.println(map.get("k1"));
        map.put("k3","v3");
    }
}
