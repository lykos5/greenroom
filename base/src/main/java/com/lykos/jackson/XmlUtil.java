package com.lykos.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

import java.util.Map;

/**
 * Created by Lykos on 16/1/7.
 */
public class XmlUtil {
    final static XmlMapper xmlMapper = new XmlMapper();


    /**
     * java对象转xml字符串
     * @param obj
     * @return
     */
    public static String serialize(Object obj){
        try{
            return xmlMapper.writeValueAsString(obj);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "";
    }


    /**
     * xml字符串转成 java对象
     * @param xmlStr
     * @param objClass
     * @return
     */
    public static Object deserialize(String xmlStr,Class objClass){
        try {
            return xmlMapper.readValue(xmlStr, objClass);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    /**
     * xml字符串转成  map对象  不支持数组
     * @param xmlStr
     * @return
     */
    public static Map deserialize(String xmlStr){
        return (Map)deserialize(xmlStr,Map.class);
    }


    /**
     * xml字符串转成 map  支持数组
     * @param xmlStr
     * @return
     */
    public static Map deserialize2(String xmlStr){
        try {
            XMLSerializer xmlSerializer = new XMLSerializer();
            JSON json = xmlSerializer.read(xmlStr);
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> jsonInMap = xmlMapper.readValue(json.toString(1),
                    new TypeReference<Map<String, Object>>() {
                    });
            return jsonInMap;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
