package com.lykos.jdk8;

import com.lykos.po.People;

import java.util.List;
import java.util.stream.Collectors;

/**
 * jdk8 方法集合
 * Created by Lykos on 16/1/18.
 */
public class ArithmeticFactory {

    /**
     * 简单的Lambda表达式
     * @return
     */
    public static ICompare<People> age(){
        return (s,d) -> s.getAge()>d.getAge();
    }

    /**
     * jdk8 过滤器,过滤之后转成list
     * @param size
     * @return
     */
    public static IFilter<People> age(int size){
        return s -> s.stream().filter(m->m.getAge()>size).collect(Collectors.toList());
    }


    public static long [] convert(List<People> peoples){
        return peoples.stream().mapToLong(x->x.getAge()).toArray();
    }

}
