package com.patterns.tutorialspoint.creational.abstractfactory;

/*
        https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm

        Step 5:
        =======
        Create a Factory generator/producer class to get factories by passing an information such as Shape
*/
public class FactoryProducer
{
    public static AbstractFactory getFactory(boolean rounded)
    {
        if (rounded) {
            return new RoundedShapeFactory();
        } else {
            return new ShapeFactory();
        }
    }
}