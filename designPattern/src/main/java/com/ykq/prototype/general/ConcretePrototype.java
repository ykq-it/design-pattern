package com.ykq.prototype.general;

/**
 * 具体的原型
 * @Date 2021/03/23
 * @Version v1.0.0
 */
public class ConcretePrototype implements IPrototype {
    private Integer id;
    private Integer sort;

    @Override
    public ConcretePrototype clone() {
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setId(id);
        prototype.setSort(sort);
        return prototype;
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "id=" + id +
                ", sort=" + sort +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
