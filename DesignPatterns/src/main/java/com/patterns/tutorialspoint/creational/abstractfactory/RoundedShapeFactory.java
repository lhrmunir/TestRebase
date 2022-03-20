package com.patterns.tutorialspoint.creational.abstractfactory;

/*
        https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm

        Step 4:
        ========
*/
public class RoundedShapeFactory extends AbstractFactory
{
    @Override
    public Shape getShape(String shapeType)
    {
        if (shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")){
            return new RoundedSquare();
        }
        return null;
    }
}
