package com.methodreference.advancedArpitMedium;

import java.util.function.Consumer;

public class MethodReferenceExistingObjectMain {
    public static void main(String[] args) {
        Country c = new Country("India");

        // Using anonymous class
        Consumer<Long> popCons1 = new Consumer<Long>() {
            @Override
            public void accept(Long t) {
                c.setPopulation(t);
            }
        };
        popCons1.accept(20000L);
        System.out.println(c);

        // Using Lambda expression
        Consumer<Long> popCons2 = (population) -> c.setPopulation(population);
        popCons2.accept(30000L);
        System.out.println(c);

        // Using method reference
        Consumer<Long> popCons3 = c::setPopulation;
        popCons3.accept(40000L);
        System.out.println(c);
    }
}