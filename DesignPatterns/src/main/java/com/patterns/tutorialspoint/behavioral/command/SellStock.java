package com.patterns.tutorialspoint.behavioral.command;

// STEP - 3

public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        System.out.println("I am SellStock...");
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}
