package com.copysun.consumer.consumerservice.model.prototype;

/**
 * @author CopySun
 * @date 2020/12/29 14:50
 * @Description
 */
public class Square extends Shape {

    public Square(){
        type="Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
