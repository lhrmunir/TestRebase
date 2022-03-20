package com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.burger;

/**
 * Created by rodicad on 25/10/2017.
 */
public class ChickenBurger extends Burger {

    @Override public String name() {
        return "Chicken Burger";
    }

    @Override public float price() {
        return (float) 4.95;
    }


}
