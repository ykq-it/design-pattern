package com.ykq.flyweight.jdk;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ykq
 * @Date 2021/6/29
 * @Version v1.0.0
 */
public class IntegerTest {
    /**
     * private static class IntegerCache {
     *      static final int low = -128;
     *      static final int high = 127;
     * }
     * 如果数在【-128，127】中，源码则使用缓存
     */
    public static void main(String[] args) {
        Integer a = Integer.valueOf(100);
        Integer b = 100;
        Integer c = Integer.valueOf(1000);
        Integer d = 1000;

        System.out.println(a == b);   // true
        System.out.println(c == d);   // false
    }
}
