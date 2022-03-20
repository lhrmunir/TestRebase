package com.patterns.tutorialspoint.structural.bridge_by_rodicad.shape;

/**
 * Created by rodicad on 26/10/2017.
 */
public abstract class Shape {
    protected DrawAPI drawAPI;


    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;

    }

    public abstract void draw();
}
