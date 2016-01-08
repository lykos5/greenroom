package com.lykos.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by Lykos on 16/1/7.
 */
public class ZkUtils {

    private final Logger log = LoggerFactory.getLogger(ZkUtils.class);


    private final static String myApp = "/lykos";


    /**
     * 在zookeeper 创建节点
     * @throws Exception
     */
    public static void regist() throws Exception{
        CuratorFramework curatorFramework = ZkClientFactory.getInstance();
        Object builder = curatorFramework.checkExists().forPath(myApp);
        if(builder==null){//判断是否存在节点
            curatorFramework.create()
                    .creatingParentsIfNeeded()
                    .forPath(myApp,(new Date().getTime()+"").getBytes());
        }else{
            curatorFramework.setData().forPath(myApp,(new Date().getTime()+"").getBytes());
        }

    }


    /**
     * zookeeper 监听
     * @throws Exception
     */
    public static void listener() throws Exception{
        CuratorFramework curatorFramework = ZkClientFactory.getInstance();
        final NodeCache nodeCache = new NodeCache(curatorFramework,myApp, false);
        nodeCache.start(true);
        System.out.println(123456);
        nodeCache.getListenable().addListener(
                new NodeCacheListener() {
                    @Override
                    public void nodeChanged() throws Exception {
                        System.out.println("Node data is changed, new data: " +
                                new String(nodeCache.getCurrentData().getData()));
                    }
                }
        );
    }
}
