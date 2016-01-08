package com.lykos.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.Date;

/**
 * Created by Lykos on 15/12/22.
 */
public class ZkClientFactory {

    private static final String myApp = "/lykos/";
    private static CuratorFramework curatorFramework;
    public static CuratorFramework getInstance(){
        if(curatorFramework == null){
            curatorFramework = CuratorFrameworkFactory.builder()
                    .connectString("127.0.0.1:2181")
                    .sessionTimeoutMs(5000)
                    .connectionTimeoutMs(3000)
                    .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                    .build();
            curatorFramework.start();
        }
        return curatorFramework;
    }



}
