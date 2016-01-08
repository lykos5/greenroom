package com.lykos.memcache;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Lykos on 16/1/8.
 */
public class MemcacheUtilTest {


    @Test
    public void get(){
        System.out.println(MemcacheUtil.get(Arrays.asList("he","hehe")));
        System.out.println(MemcacheUtil.get("hehe"));
    }


    @Test
    public void testSet(){
        System.out.println(MemcacheUtil.set("he","测试he数据"));
    }

}