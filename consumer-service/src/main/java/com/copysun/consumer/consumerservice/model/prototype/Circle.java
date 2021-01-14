package com.copysun.consumer.consumerservice.model.prototype;

/**
 * @author CopySun
 * @date 2020/12/29 14:51
 * @Description
 */
public class Circle extends Shape {

    public Circle(){
        type="Circle";
    }
    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
