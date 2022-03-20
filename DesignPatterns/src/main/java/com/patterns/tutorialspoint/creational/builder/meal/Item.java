package com.patterns.tutorialspoint.creational.builder.meal;

/*
        Step 1
        Create an interface Item representing food item and packing.
*/

import com.patterns.tutorialspoint.creational.builder.packing.Bottle;
import com.patterns.tutorialspoint.creational.builder.packing.Packing;
import com.patterns.tutorialspoint.creational.builder.packing.Wrapper;


public interface Item
{
    public String name();
    public Packing packing();
    public float price();
}
