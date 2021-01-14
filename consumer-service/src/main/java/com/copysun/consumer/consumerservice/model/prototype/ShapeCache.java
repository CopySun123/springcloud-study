package com.copysun.consumer.consumerservice.model.prototype;

import java.util.Hashtable;

/**
 * @author CopySun
 * @date 2020/12/29 14:52
 * @Description
 */
public class ShapeCache {

    private static Hashtable<String,Shape> shapeMap=new Hashtable<>();

    public static Shape getShape(String shapeId) throws CloneNotSupportedException {
        Shape cachedShape = shapeMap.get(shapeId);
            return (Shape) cachedShape.clone();
    }

    public static void loadCache(){
        Circle circle=new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);


        Square square=new Square();
        square.setId("2");
        shapeMap.put("2",square);

        Rectangle rectangle=new Rectangle();
        rectangle.setId("3");
        shapeMap.put("3",rectangle);
    }

}
