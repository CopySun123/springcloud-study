package com.copysun.consumer.consumerservice.model.prototype;

/**
 * @author CopySun
 * @date 2020/12/29 15:05
 * @Description
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        try {
            Shape cloneShape1 = ShapeCache.getShape("1");
            cloneShape1.draw();

            Shape cloneShape2 = ShapeCache.getShape("2");
            cloneShape2.draw();

            Shape cloneShape3=ShapeCache.getShape("3");
            cloneShape3.draw();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
