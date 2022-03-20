package com.patterns.tutorialspoint.structural.bridge_by_rodicad.shape;

/**
 * Created by rodicad on 26/10/2017.
 */
public class Circle extends Shape {
    private int x;
    private int y;
    private int radius;

    public Circle (int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle( x,y,radius );;

    }
}
