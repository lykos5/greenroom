package com.lykos.regex;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * 
 * Matcher普通方法 
 * @author Lykos
 *
 */
public class MatchesBase {

    private static final String REGEX = "abc";
    private static final String INPUT = "abcccccccabcccccccabcccc";
    
    /**
     * Pattern类用于创建一个正则表达式,也可以说创建一个匹配模式,它的构造方法是私有的,不可以直接创建,
     * 但可以通过Pattern.complie(String regex)简单工厂方法创建一个正则表达式
     */
    private static Pattern pattern;
    
    /**
     * Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持
     */
    private static Matcher matcher;

    /**
     * 
     * 
     * Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持
     * 
     * 
     * 
    matches:整个匹配，只有整个字符序列完全匹配成功，才返回True，否则返回False。
    lookingAt:部分匹配，总是从第一个字符进行匹配,匹配成功了不再继续匹配，
         匹配失败了,也不继续匹配。
    find:部分匹配，从当前位置开始匹配，找到一个匹配的子串，将移动下次匹配的位置。
    reset:给当前的Matcher对象配上个新的目标，目标是就该方法的参数；
        如果不给参数，reset会把Matcher设到当前字符串的开始处。 
        
        
        start()返回匹配到的子字符串在字符串中的索引位置.
        end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
        group()返回匹配到的子字符串
        只有当匹配操作成功,才可以使用start(),end(),group()三个方法
     */
    public static void main(String[] args) {
   
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(INPUT);

        System.out.println("Current REGEX is: "+REGEX);
        System.out.println("Current INPUT is: "+INPUT);

        System.out.println("lookingAt(): "+matcher.lookingAt());
        System.out.println("start(): "+matcher.start());
        System.out.println("end(): "+matcher.end());
        System.out.println("---------------------------------------");
        System.out.println("matches(): "+matcher.matches());
        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+matcher.start());
            System.out.println("group(): "+matcher.group());
            System.out.println("end(): "+matcher.end());
        }
    }
}