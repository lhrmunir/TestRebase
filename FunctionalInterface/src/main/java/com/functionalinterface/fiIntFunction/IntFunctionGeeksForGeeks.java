package com.functionalinterface.fiIntFunction;
/*
https://www.geeksforgeeks.org/intfunction-interface-in-java-with-examples/

        The IntFunction Interface is a part of the java.util.function package which has been introduced since Java 8, to implement functional programming in Java. It represents a function which takes in an int-valued argument and produces a result of type R.

        This functional interface takes in only one generic, namely:-

        R: denotes the type of the output of this function
        The lambda expression assigned to an object of IntFunction type is used to define its apply() which eventually applies the given operation on its only argument. It is similar to using an object of type Function<Integer, R>.

        The IntFunction interface has only one function:

        apply()
        This method accepts an int-valued argument and gives a result of type R.

 */

import java.util.function.IntFunction;

public class IntFunctionGeeksForGeeks
{
    public static void main(String args[])
    {
        IntFunction<Double> ob = a -> a / 2.0;

        // Using apply() method
        System.out.println(ob.apply(3));
    }
}
