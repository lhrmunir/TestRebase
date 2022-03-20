package com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.burger;

/**
 * Created by rodicad on 25/10/2017.
 */
public class VeggieBurger extends Burger {

    @Override public String name() {
        return "Veggie Burger";
    }

    @Override public float price() {
        return (float) 5.45;
    }

}
