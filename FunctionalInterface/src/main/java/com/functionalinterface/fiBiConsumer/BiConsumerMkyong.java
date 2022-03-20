package com.functionalinterface.fiBiConsumer;

import java.util.function.BiConsumer;

public class BiConsumerMkyong {

    public static void main(String[] args) {

        BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println(x + y);
        addTwo.accept(1, 2);    // 3
        // ---------- OR ------------
        BiConsumer<String, String> bc = (x, y) -> { System.out.println(x + y); };
        bc.accept("aaaaaa","bbbbbb");
        // BiConsumer<Integer, Integer> addTwo2ndWay = (7, 11) -> System.out.println(x + y);

    }
}
