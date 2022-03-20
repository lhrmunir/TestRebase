package com.patterns.tutorialspoint.creational.prototype;

public class ShapesContainer {
}

/*
Step 2
        Create concrete classes extending the above class.

        Rectangle.java
*/
// public class Rectangle extends Shape {
class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

// Square.java
// public class Square extends Shape {
class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

// Circle.java
class Circle extends Shape {
// public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

