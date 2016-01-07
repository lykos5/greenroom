package com.lykos.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Created by Lykos on 16/1/7.
 */
public class JsonUtil {

    final static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * java 对象转成json对象
     * @param obj
     * @return
     */
    public static String serialize(Object obj){
        try {
            return objectMapper.writeValueAsString(obj);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "";
    }


    /**
     * 字符串转成 java对象
     * @param jsonStr
     * @param objClass
     * @return
     */
    public static Object deserialize(String jsonStr,Class objClass){
        try {
            return objectMapper.readValue(jsonStr, objClass);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    /**
     * 字符串转成  map对象
     * @param jsonStr
     * @return
     */
    public static Map deserialize(String jsonStr){
        return (Map)deserialize(jsonStr,Map.class);
    }
}
