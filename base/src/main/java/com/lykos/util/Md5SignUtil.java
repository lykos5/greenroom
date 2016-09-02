package com.lykos.util;

import com.google.common.collect.ImmutableMap;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by lykos on 16/9/1.
 * md5 签名工具类
 * md5 签名返回的是128位的信息,也就是16个字节byte
 * 0的原码、补码都是0，正数的原码、补码可以特殊理解为相同，负数的补码是它的反码加1
 * 所谓反码就是把负数的原码各个位按位取反
 * 负数的原码和和它的绝对值所对应的原码相同，简单的说就是绝对值相同的数原码相同
 */
public class Md5SignUtil {

    // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public Md5SignUtil() {
    }

    /**
     * byte10进制转为16进制,两位数表示不足的前面用0
     * 如:10不足16的倍数,转16进制就是0a
     * @param bByte
     * @return
     */
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    /**
     *此方法和上面方法byteToArrayString达到的是同一效果
     * @param bByte
     * @return
     */
    private static String byteToArrayString2(byte bByte) {
        String str = "";
        int iRet = bByte<0?bByte+256:bByte;
        if (iRet < 16) {
            str = "0";
        }
        return str+Integer.toHexString(iRet);
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            //sBuffer.append(byteToArrayString(bByte[i]));
            sBuffer.append(byteToArrayString2(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String getMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    /**
     * MD5加密16位就是32位的8-24
     * @param strObj
     * @return
     */
    public static String getMD5Code16(String strObj) {
        return getMD5Code(strObj).substring(8,24);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toHexString(127));
        System.out.println(getMD5Code("刘俊4"));
        signByMap(ImmutableMap.of("k","v2"),"123456");
        System.out.println(getMD5Code16("刘俊4"));
    }

    /**
     * 根据map签名  map相当于请求参数
     * @param map
     * @param secret  双方约定的密钥
     * @return
     */
    public static String signByMap(Map map, String secret) {
        List<String> keyList = new ArrayList<String>();
        keyList.addAll(map.keySet());
        //根据字典大小排序
        Collections.sort(keyList);
        StringBuffer sb = new StringBuffer(secret);
        for(String key : keyList){
            if("sign".equals(key)){
                continue;
            }
            String value = map.getOrDefault(key,"").toString();
            if(value!=null){
                sb.append(key);
                sb.append(value);
            }
        }
        sb.append(secret);
        System.out.println("加密前字符串：" + sb.toString());
        String sign = getMD5Code(sb.toString());
        System.out.println("加密后字符串:"+sign);
        return sign;
    }
}
