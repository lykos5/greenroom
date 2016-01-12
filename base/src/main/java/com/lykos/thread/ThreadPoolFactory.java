package com.lykos.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Lykos on 16/1/6.
 */
public class ThreadPoolFactory {

    private static int size = 2;

    public static ExecutorService getExecutorService(){
        return Executors.newFixedThreadPool(size,new OwnThreadFactory());
    }


    public static ExecutorService getExecutorService(int size){
        return Executors.newFixedThreadPool(size,new OwnThreadFactory());
    }
}
