package com.generic.example;

public class GenericMethodExample1 {
    public static void main(String[] args) {

        // initialize the class with Integer data
        DemoMethodClass demo = new DemoMethodClass();

        // generics method working with String
        demo.<String>genericsMethod("Java Programming");
        // ---- OR -----
        demo.genericsMethod("Java Programming [SHORT]");

        // generics method working with integer
        demo.<Integer>genericsMethod(25);
        // ---- OR -----
        demo.genericsMethod(99);
    }
}

class DemoMethodClass {

    /*
        creae a generics method

        Here, the type parameter <T> is inserted after the modifier public and before the return type void.

     */
    public <T> void genericsMethod(T data) {
        System.out.println("Generics Method:");
        System.out.println("Data Passed: " + data);
    }
}
