package com.patterns.tutorialspoint.creational.builder_by_rodicad.meal;

import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.burger.ChickenBurger;
import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.burger.VeggieBurger;
import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.drink.Coke;
import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.drink.Cola;

/**
 * Created by rodicad on 25/10/2017.
 */
public class MealBuilder {
    public Meal meal;

    public Meal prepareVeggieMeal() {
        Meal meal = new Meal();
        meal.addItem( new VeggieBurger() );
        meal.addItem( new Coke() );
        return meal;
    }

    public Meal prepareChickenMeal() {
        Meal meal = new Meal();
        meal.addItem( new ChickenBurger() );
        meal.addItem( new Cola() );
        return meal;
    };



}
