package com.ykq.prototype.shallow;

import java.util.List;

/**
 * 具体的原型
 * @Date 2021/03/23
 * @Version v1.0.0
 */
public class ConcretePrototype implements Cloneable {
    private Integer id;
    private String sort;
    private List<String> books;

    @Override
    public ConcretePrototype clone() {
        try {
            return (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "id=" + id +
                ", sort='" + sort + '\'' +
                ", books=" + books +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
