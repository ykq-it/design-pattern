package com.ykq.builder.general;

/**
 * @Date 2021/03/23
 * @Version v1.0.0
 */
public class ConcreteBuilder implements IBuilder {
    private Product product = new Product();
    @Override
    public Object build() {
        return product;
    }
}
