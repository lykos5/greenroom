package com.lykos.memcache;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


/**
 * Created by Lykos on 16/1/8.
 */
public class MemcacheUtil {

    static Logger logger = LoggerFactory.getLogger(MemcacheUtil.class);

    private static MemcachedClient memcachedClient = null;



    public static boolean flushAll() {
        if (init()) {
            try {
                memcachedClient.flushAll();
                return true;
            } catch (Exception e) {
                logger.error("MemcachedHelper flushAll:" + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /**
     * 根据key得到value
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        if (init()) {
            try {
                return memcachedClient.get(key);
            } catch (Exception e) {
                logger.error("MemcachedHelper key is " + key);
            }
        }
        return null;
    }


    /**
     * 根据key得到value
     * @param keys
     * @return
     */
    public static Map<String,Object> get(List<String> keys) {
        if (init()) {
            try {
                return memcachedClient.get(keys);
            } catch (Exception e) {
                logger.error("MemcachedHelper key is " + keys);
            }
        }
        return null;
    }


    /**
     * 将key-value存入缓存
     *
     * @param key    存储的key名称，
     * @param value  实际存储的数据
     * @param expiry 是expire时间（单位秒），超过这个时间,memcached将这个数据替换出去，0表示永久存储（默认是一个月)
     * @return
     */
    public static boolean set(String key, Object value, int expiry) {
        if (init()) {
            if (null != value) {
                try {
                    return memcachedClient.set(key, expiry, value);
                } catch (Exception e) {
                    logger.error("MemcachedHelper key is " + key);
                }
            } else {
                logger.error("MemcachedHelper key is " + key);
            }
        }
        return false;
    }

    /**
     * 将key-value存入缓存,永久存储（默认是一个月)
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean set(String key, Object value) {
        return set(key, value, 0);
    }

    /**
     * 根据key删除value
     *
     * @param key
     * @return
     */
    public static boolean delete(String key) {
        if (init()) {
            try {
                return memcachedClient.delete(key);
            } catch (Exception e) {
                logger.error("MemcachedHelper key is " + key);
            }
        }
        return false;
    }

    /**
     * 初始化
     * @return
     */
    private static boolean init(){
        boolean flag = true;
        if(memcachedClient == null){
            try {
                MemcachedClientBuilder builder = new XMemcachedClientBuilder(
                        AddrUtil.getAddresses("127.0.0.1:11211"));
                memcachedClient = builder.build();
            }catch(Exception ex){
                flag = false;
                ex.printStackTrace();
            }
        }
        return flag;
    }
}
