package com.copysun.consumer.consumerservice.model;

/**
 * @author CopySun
 * @date 2020/12/28 10:59
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Director director = new Director();
        Product create = director.create(new ConcreteBuilder());
        System.out.println(create.toString());
    }
}
