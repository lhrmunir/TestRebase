package com.patterns.tutorialspoint.creational.builder.packing;

/*
Step 2
        Create concrete classes implementing the Packing interface.

        Wrapper.java
*/

public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}