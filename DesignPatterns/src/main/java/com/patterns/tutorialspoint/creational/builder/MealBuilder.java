package com.patterns.tutorialspoint.creational.builder;

import com.patterns.tutorialspoint.creational.builder.meal.Coke;
import com.patterns.tutorialspoint.creational.builder.meal.Pepsi;
import com.patterns.tutorialspoint.creational.builder.meal.Meal;
import com.patterns.tutorialspoint.creational.builder.meal.VegBurger;
import com.patterns.tutorialspoint.creational.builder.meal.ChickenBurger;

/*
        Step 6:
        =========
        Create a MealBuilder class, the actual builder class responsible to create Meal objects.
*/
public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}

