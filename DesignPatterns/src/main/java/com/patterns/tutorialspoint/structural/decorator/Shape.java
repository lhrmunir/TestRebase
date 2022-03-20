package com.patterns.tutorialspoint.structural.decorator;

/*
    https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm

    Step 1
*/
public interface Shape {
    void draw();
}
/*
Step 2
        Create concrete classes implementing the same interface.

        Rectangle.java
*/
// public class Rectangle implements Shape {
class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
/*
Circle.java
*/
// public class Circle implements Shape {
class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
