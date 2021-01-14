package com.copysun.consumer.consumerservice.model;

/**
 * @author CopySun
 * @date 2020/12/28 10:55
 * @Description
 */
public class ConcreteBuilder extends Builder {

    private Product product=new Product();

    @Override
    Builder bulidA() {
        product.setBuildA("地基");
        return this;
    }

    @Override
    Builder bulidB() {
        product.setBuildB("钢筋工程");
        return this;
    }

    @Override
    Builder bulidC() {
        product.setBuildC("铺电线");
        return this;
    }

    @Override
    Builder bulidD() {
        product.setBuildD("粉刷");
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}
