package com.patterns.tutorialspoint.creational.builder.meal;

import com.patterns.tutorialspoint.creational.builder.packing.Packing;
import com.patterns.tutorialspoint.creational.builder.packing.Wrapper;
/*
Step 3
        Create abstract classes implementing the item interface providing default functionalities.

        Burger.java
*/
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
