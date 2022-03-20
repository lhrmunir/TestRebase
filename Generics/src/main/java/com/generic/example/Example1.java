package com.generic.example;

// please see Read.Me.txt

public class Example1 {

    public static void main(String[] args) {

        // initialize the class with Integer data
        DemoClass demo = new DemoClass();

        // generics method working with String
        demo.<String>genericsMethod("Java Programming");
        // -- or -- without <String>
        demo.genericsMethod("Java Programming");

        // generics method working with integer
        demo.<Integer>genericsMethod(25);
        // -- or -- without <Integer>
        demo.genericsMethod(25);

        printArray(new Integer[]{ 1,2,3,4,5,6,7,8,9,10 });

        printArray(new String[]{ "one", "two", "three", "four", "five" });
    }

    public static <h> void printArray( h[] inputArray ) {
        // Display array elements
        for ( h element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }



}

class DemoClass {

    // creae a generics method
    public <T> void genericsMethod(T data) {
        System.out.println("Generics Method:");
        System.out.println("Data Passed: " + data);
    }
}
