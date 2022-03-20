package com.patterns.tutorialspoint.creational.abstractfactory;

/*
        https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm

        Abstract Factory patterns work around a super-factory which creates other factories. This factory is also called as factory of factories.
        This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.

        In Abstract Factory pattern an interface is responsible for creating a factory of related objects without explicitly specifying their classes.
        Each generated factory can give the objects as per the Factory pattern.

        Implementation :
        =================
        We are going to create a Shape interface and a concrete class implementing it. We create an abstract factory class AbstractFactory as next step.
        Factory class ShapeFactory is defined, which extends AbstractFactory. A factory creator/generator class FactoryProducer is created.

        AbstractFactoryPatternDemo, our demo class uses FactoryProducer to get a AbstractFactory object.
        It will pass information (CIRCLE / RECTANGLE / SQUARE for Shape) to AbstractFactory to get the type of object it needs.
*/
public interface Shape {
    void draw();
}

// Step 2
// Create concrete classes implementing the same interface.

// RoundedRectangle.java
// public class RoundedRectangle implements Shape {
class RoundedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside RoundedRectangle::draw() method.");
    }
}

// RoundedSquare.java
// public class RoundedSquare implements Shape {
class RoundedSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside RoundedSquare::draw() method.");
    }
}

// Rectangle.java
// public class Rectangle implements Shape {
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

// Square.java
// public class Rectangle implements Shape {
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
