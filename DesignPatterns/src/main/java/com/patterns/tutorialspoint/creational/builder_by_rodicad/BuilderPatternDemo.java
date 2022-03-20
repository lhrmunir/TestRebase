package com.patterns.tutorialspoint.creational.builder_by_rodicad;

import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.Meal;
import com.patterns.tutorialspoint.creational.builder_by_rodicad.meal.MealBuilder;

public class BuilderPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealOrder = new MealBuilder();
        Meal meal = mealOrder.prepareVeggieMeal();
        meal.showItems();
        System.out.println("meal total price: "+meal.getCost());

    }
}
