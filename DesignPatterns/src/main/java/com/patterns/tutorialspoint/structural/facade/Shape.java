package com.patterns.tutorialspoint.structural.facade;

/*
        https://www.tutorialspoint.com/design_pattern/facade_pattern.htm
*/
public interface Shape {
    void draw();
}

// Step 2
// Create concrete classes implementing the same interface.

// Rectangle.java
// public class Rectangle implements Shape {
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

// Square.java
// public class Square implements Shape {
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}

// Circle.java
// public class Circle implements Shape {
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
