package com.lykos.regex;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据替换
 * @author Lykos
 *
 */
@SuppressWarnings("unchecked")//去掉提醒
public class MatcherAppendDemo {
 
	//必须要懒惰模式 
    private static String REGEX = "\\$\\{(.+?)\\}";//\\为转义字符  加?代表懒惰模式  否则是贪婪模式
    private static String INPUT = "我的名字叫:${name},生日是:${birthday},家在:${address}.很高兴认识你!";
    private static Pattern pattern;
    private static Matcher matcher;
    private static Map KEY_VALUE;
    static{
    	KEY_VALUE = new HashMap();//不同步(不安全),可以存放null value值中可以重复null
    	//但  HashTable 同步(安全) key value 不能有null
    	KEY_VALUE.put("name", "Lykos");
    	KEY_VALUE.put("birthday", "0926");
    	KEY_VALUE.put("address", "湖北恩施");
    	
    }
 
    public static void main(String[] args) {
    	pattern = Pattern.compile(REGEX);
    	matcher = pattern.matcher(INPUT);  
        StringBuffer strB = new StringBuffer();//结果数据缓冲区
        while(matcher.find()){
        	String key = matcher.group(1);//因为正则表达式中有()代表分组
        	Object value = KEY_VALUE.get(key);
        	String replace = "";
        	if(value!=null){
        		replace = value.toString();
        	}
        	matcher.appendReplacement(strB, replace);//追加当前字符串
            System.out.println(strB.toString());
        }
        matcher.appendTail(strB);//追加最后字符串
        System.out.println(strB.toString());
    }
}