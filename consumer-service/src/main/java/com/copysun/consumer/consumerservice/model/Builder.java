package com.copysun.consumer.consumerservice.model;

/**
 * @author CopySun
 * @date 2020/12/28 10:53
 * @Description
 */
public abstract class Builder {

    //地基
    abstract Builder bulidA();
    //钢筋工程
    abstract Builder bulidB();
    //铺电线
    abstract Builder bulidC();
    //粉刷
    abstract Builder bulidD();

    abstract Product getProduct();
}
