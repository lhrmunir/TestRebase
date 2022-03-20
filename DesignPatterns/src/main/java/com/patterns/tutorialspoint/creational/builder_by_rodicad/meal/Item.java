package com.patterns.tutorialspoint.creational.builder_by_rodicad.meal;

import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.packing.Packing;

/**
 * Created by rodicad on 25/10/2017.
 */
public interface Item {
    public String name();
    public float price();
    public Packing packing();

}
