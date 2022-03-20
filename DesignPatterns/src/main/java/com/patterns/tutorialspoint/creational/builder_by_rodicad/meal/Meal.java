package com.patterns.tutorialspoint.creational.builder_by_rodicad.meal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodicad on 25/10/2017.
 */
public class Meal {
    private float cost = 0;
    public List<Item> mealItems = new ArrayList<>();

    public void addItem( Item item ) {
        mealItems.add( item );
    }

    public float getCost() {
        for ( Item item : mealItems ) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for ( Item item : mealItems ) {
            System.out.println( "item: " + item.name() );
            System.out.println( "packing: " + item.packing().pack() );
            System.out.println( "price: " + item.price() );

        }
    }

}
