package com.lykos.zookeeper;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Lykos on 16/1/7.
 */
public class ZkUtilsTest {

    @Test
    public void testRegist() throws Exception{
        ZkUtils.regist();
    }


    @Test
    public void testListener() throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZkUtils.listener();
        countDownLatch.await();
    }

}