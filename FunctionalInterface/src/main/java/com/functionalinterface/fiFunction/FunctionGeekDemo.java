package com.functionalinterface.fiFunction;

import java.util.function.Function;

/*
    https://www.geeksforgeeks.org/function-interface-in-java-with-examples/
*/
/*
    The Function Interface is a part of the java.util.function package which has been introduced since Java 8, to implement functional programming in Java.
    It represents a function which takes in one argument and produces a result. Hence this functional interface takes in 2 generics namely as follows:
        T: denotes the type of the input argument
        R: denotes the return type of the function

    The Function interface consists of the following 4 methods as listed which are later discussed as follows:
        apply()
        andThen()
        compose()
        identity()
 */
public class FunctionGeekDemo {

    public static void main(String args[])
    {
        // Function which takes in a number and returns half of it
        Function<Integer, Double> half = a -> a / 2.0;

        // Applying the function to get the result
        System.out.println(half.apply(10));
        /* ---------------------------------------------------------------------------------------- */

        // Function<Integer, Double> half = a -> a / 2.0; -- already defined at top

        // Now treble the output of half function
        half = half.andThen(a -> 3 * a);

        /*
            R apply(T t)
                Parameters  : This method takes in only one parameter t which is the function argument
                Return Type : This method returns the function result which is of type R.
        */
        System.out.println(half.apply(10));
        /* ------------------------------------------------------------------ */

        // Function which takes in a number and returns half of it
        // Function<Integer, Double> half = a -> a / 2.0; -- already defined at top

        // Try block to check for exceptions
        try {
            // Trying to pass null as parameter
            /*
                andThen()
                    It returns a composed function wherein the parameterized function will be executed after the first one.
                    If evaluation of either function throws an error, it is relayed to the caller of the composed function.

                    Syntax:
                    default <V> Function<T, V>
                    andThen(Function<? super R, ? extends V> after)
                    where V is the type of output of the after function, and of the composed function

                    Parameters: This method accepts a parameter after which is the function to be applied after the current one.\
                    Return Value: This method returns a composed function that applies the current function first and then the after function

                    Exception: This method throws NullPointerException if the after function is null.
             */

            half = half.andThen(null);
        }
        catch (Exception e) {
            System.out.println("Exception thrown " + "while passing null: " + e);
        }
        /* ------------------------------------------------------------------ */

        // Function which takes in a number and returns half of it
        // Function<Integer, Double> half = a -> a / 2.0; -- already defined at top

        // However treble the value given to half function
        half = half.compose(a -> 3 * a);

        // Applying the function to get the result
        System.out.println(half.apply(5));
        /* ------------------------------------------------------------------ */

        // Function which takes in a number and returns half of it
        // Function<Integer, Double> half = a -> a / 2.0; -- already defined at top

        try {
            // Trying to pass null as parameter
            /*
            compose()
                It returns a composed function wherein the parameterized function will be executed first and then the first one. If evaluation of either function throws an error, it is relayed to the caller of the composed function.

                Syntax:
                default <V> Function<V, R>
                compose(Function<? super V, ? extends T> before)
                Where V is the type of input of the before function, and of the composed function

                Parameters: This method accepts a parameter before which is the function to be applied first and then the current one

                Return Value: This method returns a composed function that applies the current function after the parameterized function

                Exception: This method throws NullPointerException if the before function is null.
             */
            half = half.compose(null);
        }
        catch (Exception e) {

            System.out.println("Exception thrown " + "while passing null: " + e);
        }
        /* ------------------------------------------------------------------ */

        /*
        identity()
            This method returns a function that returns its only argument.

            Syntax:
            static <T> Function<T, T> identity()
            where T denotes the type of the argument and the value to be returned

            Returns: This method returns a function that returns its own argument
         */
        // Function which takes in a number and returns it
        Function<Integer, Integer> i = Function.identity();

        // Print statement
        System.out.println(i.apply(10));
    }

}
