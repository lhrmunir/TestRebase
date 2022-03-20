package com.concept.example;

public class Money {

    int amount;
    String currencyCode;

    public static void main(String[] args){

        Money income = new Money(55, "USD");
        Money expenses = new Money(55, "USD");

        boolean balanced = income.equals(expenses);

        System.out.println("balanced = " + balanced);
    }

    Money(int amount, String currencyCode)
    {
        this.amount = amount;
        this.currencyCode = currencyCode;

    }

}
