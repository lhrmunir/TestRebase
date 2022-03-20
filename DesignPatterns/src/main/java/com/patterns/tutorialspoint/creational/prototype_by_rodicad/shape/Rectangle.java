package com.patterns.tutorialspoint.creational.prototype_by_rodicad.shape;

/**
 * Created by rodicad on 25/10/2017.
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = "rectangle";
    }

    @Override void draw() {
        System.out.println("Rectangle: inside the draw method");
    }
}
