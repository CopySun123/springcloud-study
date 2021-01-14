package com.copysun.consumer.consumerservice.model;

/**
 * @author CopySun
 * @date 2020/12/28 10:58
 * @Description
 */
public class Director {
    //指挥工人按顺序造房
    public Product create(Builder builder) {

        return builder.bulidA().bulidB().bulidC().bulidD().getProduct();
    }
}
