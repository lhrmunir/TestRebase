package com.patterns.tutorialspoint.behavioral.command;

/*
Step 3
        Create concrete classes implementing the Order interface.
*/

public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        System.out.println("I am BuyStock...");
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}
