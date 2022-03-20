package com.patterns.tutorialspoint.structural.decorator;

/*
Step 3
        Create abstract decorator class implementing the Shape interface.
*/

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}