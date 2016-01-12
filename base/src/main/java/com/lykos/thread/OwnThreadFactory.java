package com.lykos.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 自定义的ThreadFactory工厂，增加对线程创建与销毁等更多的控制
 * Created by Lykos on 16/1/12.
 */
public class OwnThreadFactory implements ThreadFactory {

    private AtomicLong atomicLong = new AtomicLong(1);//线程序列数
    @Override
    public Thread newThread(Runnable r) {
        long index = atomicLong.incrementAndGet();
        System.out.println("线程:"+index+"创建!");
        return new Thread(r,"线程:"+index);
    }
}
