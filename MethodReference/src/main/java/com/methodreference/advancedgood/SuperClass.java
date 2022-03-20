package com.methodreference.advancedgood;

/*
        for:
        http://blog.marcinchwedczuk.pl/method-references-in-java-8
*/

// The last example that I want to present illustrates how to use method references to refer to super class methods:

public abstract class SuperClass {

    void method() {
        System.out.println("superclass method()");
    }
}