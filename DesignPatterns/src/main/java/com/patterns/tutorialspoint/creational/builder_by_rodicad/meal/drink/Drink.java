package com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.drink;

import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.packing.Bottled;
import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.packing.Packing;
import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.Item;

/**
 * Created by rodicad on 25/10/2017.
 */
public abstract class Drink implements Item {
    public abstract String name();

    @Override public Packing packing() {
        return new Bottled();
    }
}
