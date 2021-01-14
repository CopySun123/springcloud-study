package com.copysun.consumer.consumerservice.model.prototype;

import lombok.Getter;
import lombok.Setter;

/**
 * @author CopySun
 * @date 2020/12/29 14:06
 * @Description  原型抽象类
 */
public abstract class Shape implements Cloneable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    protected String type;

    abstract void draw();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
