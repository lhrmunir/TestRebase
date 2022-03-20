package com.patterns.tutorialspoint.creational.builder.meal;

import com.patterns.tutorialspoint.creational.builder.packing.Packing;
import com.patterns.tutorialspoint.creational.builder.packing.Bottle;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
