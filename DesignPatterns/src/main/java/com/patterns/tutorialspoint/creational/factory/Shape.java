package com.patterns.tutorialspoint.creational.factory;

/*
    https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
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
        System.out.println("Inside Rectangle::draw() method.");
    }
}

// Square.java
// public class Square implements Shape {
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

// Circle.java
// public class Circle implements Shape {
class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
