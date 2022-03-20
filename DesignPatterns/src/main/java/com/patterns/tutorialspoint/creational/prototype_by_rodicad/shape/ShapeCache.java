package com.patterns.tutorialspoint.creational.prototype_by_rodicad.shape;

import java.util.Hashtable;

/**
 * Created by rodicad on 25/10/2017.
 */
public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>(  );

    public static Shape getShape(String id) {
        Shape cachedShape = shapeMap.get( id );
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId( "1" );
        shapeMap.put( circle.getId(), circle );

        Rectangle rectangle = new Rectangle();
        rectangle.setId( "2" );
        shapeMap.put( rectangle.getId(), rectangle );

    }


}
