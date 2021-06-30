package com.ykq.flyweight.jdk;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ykq
 * @Date 2021/6/29
 * @Version v1.0.0
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "hel" + "lo";
        String s4 = "he" + new String("llo");
        String s5 = new String("hello");
        String s6 = s5.intern();
        String s7 = "h";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2);   // true
        System.out.println(s1 == s3);   // true
        System.out.println(s1 == s4);   // false
        System.out.println(s1 == s5);   // false
        System.out.println(s4 == s5);   // false
        System.out.println(s1 == s6);   // true
        System.out.println(s1 == s9);   // false
    }
}
