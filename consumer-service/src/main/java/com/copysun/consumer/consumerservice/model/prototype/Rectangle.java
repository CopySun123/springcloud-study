package com.copysun.consumer.consumerservice.model.prototype;

/**
 * @author CopySun
 * @date 2020/12/29 14:09
 * @Description
 */
public class Rectangle extends Shape {
    public Rectangle(){
        type="Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
