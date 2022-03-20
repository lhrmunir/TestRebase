package com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.burger;

import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.packing.Packing;
import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.packing.Wrapping;
import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.Item;

/**
 * Created by rodicad on 25/10/2017.
 */
public abstract class Burger implements Item {

    @Override public Packing packing() {
        return new Wrapping();
    }





}
