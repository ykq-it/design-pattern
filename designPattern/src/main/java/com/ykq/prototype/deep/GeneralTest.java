package com.ykq.prototype.deep;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/03/23
 * @Version v1.0.0
 */
public class GeneralTest {
    public static void main(String[] args) {
        ConcretePrototype c1 = new ConcretePrototype();
        c1.setId(1);
        c1.setSort("sort");
        List<String> books = new ArrayList<>();
        books.add("a");
        books.add("b");
        c1.setBooks(books);

        ConcretePrototype c2 = c1.deepClone();
        c2.getBooks().add("c");
        System.out.println("克隆对象：" + c2);
        System.out.println("原型对象：" + c1);
        System.out.println(c1 == c2);

        System.out.println("克隆对象book：" + c2.getBooks());
        System.out.println("原型对象book：" + c1.getBooks());
        System.out.println(c1.getBooks() == c2.getBooks());
    }
}
