package com.methodreference.advancedgood;

/*
        for:
        http://blog.marcinchwedczuk.pl/method-references-in-java-8
*/

//    The last example that I want to present illustrates how to use method references to refer to super class methods:

public class SubClass extends SuperClass {
    @Override
    void method() {
        Runnable superMethodL = () -> super.method();
        Runnable superMethodMR = SubClass.super::method;

        superMethodL.run();
        superMethodMR.run();
    }

    public static void main(String [] q)
    {
        SubClass subClass = new SubClass();

        subClass.method();

    }
}
