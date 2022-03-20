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
 ============================================================================================================================================

        Step 6:
        =======
        Use the FactoryProducer to get AbstractFactory in order to get factories of concrete classes by passing an information such as type.
*/

public class AbstractFactoryPatternDemo
{
    public static void main(String[] args)
    {
        // get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);

        // get an object of Shape Rectangle
        Shape shape1 = shapeFactory.getShape("RECTANGLE");

        // call draw method of Shape Rectangle
        shape1.draw();

        // get an object of Shape Square
        Shape shape2 = shapeFactory.getShape("SQUARE");

        // call draw method of Shape Square
        shape2.draw();

        // get shape factory
        AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);

        // get an object of Shape Rectangle
        Shape shape3 = shapeFactory1.getShape("RECTANGLE");

        // call draw method of Shape Rectangle
        shape3.draw();

        // get an object of Shape Square
        Shape shape4 = shapeFactory1.getShape("SQUARE");

        // call draw method of Shape Square
        shape4.draw();
    }
}
