package com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.drink;

/**
 * Created by rodicad on 25/10/2017.
 */
public class Coke extends Drink {

    @Override public float price() {
        return (float) 1.25;
    }

    @Override public String name() {
        return "coke";
    }
}
