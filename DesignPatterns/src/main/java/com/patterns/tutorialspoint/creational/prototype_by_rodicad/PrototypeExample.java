package com.patterns.tutorialspoint.creational.prototype_by_rodicad;

import com.patterns.tutorialspoint.creational.prototype_by_rodicad.shape.Shape;
import com.patterns.tutorialspoint.creational.prototype_by_rodicad.shape.ShapeCache;

/**
 * Created by rodicad on 25/10/2017.
 */
public class PrototypeExample {

    public static void main (String[] args) {
        ShapeCache.loadCache();

        Shape clonedCircle = ShapeCache.getShape( "1" );
        Shape clonedRectangle = ShapeCache.getShape( "2" );

        System.out.println("Cloned circle: "+clonedCircle.getType());
        System.out.println("Cloned rectangle: "+clonedRectangle.getType());


    }

}
