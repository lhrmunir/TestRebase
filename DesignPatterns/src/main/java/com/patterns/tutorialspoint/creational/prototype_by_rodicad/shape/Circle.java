package com.patterns.tutorialspoint.creational.prototype_by_rodicad.shape;

/**
 * Created by rodicad on 25/10/2017.
 */
public class Circle extends Shape {

    public Circle() {
        type = "circle";
    }

    @Override void draw() {
        System.out.println("Circle: inside the draw method");
    }
}
