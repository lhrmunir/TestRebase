package com.patterns.tutorialspoint.creational.abstractfactory;

/*
        https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm

        Step 4
        ======
        Create Factory classes extending AbstractFactory to generate object of concrete class based on given information.
*/
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){
        if (shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
