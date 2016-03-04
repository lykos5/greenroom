package com.lykos.data.string;

import org.junit.Test;

/**
 * Created by Lykos on 16/3/4.
 */
public class StringDataTest {

    @Test
    public void testCacheSpace(){
        String mes_a = "123";
        String mes_aa = new String("123");
        String mes_aaaa = mes_aa;
        String mes_aaa = mes_aa.intern();
        System.out.println(mes_a == mes_aa);
        System.out.println(mes_a == mes_aaa);
        System.out.println(mes_aa == mes_aaa);
        System.out.println(mes_aa == mes_aaaa);
        System.out.println(mes_aaaa);
    }
}