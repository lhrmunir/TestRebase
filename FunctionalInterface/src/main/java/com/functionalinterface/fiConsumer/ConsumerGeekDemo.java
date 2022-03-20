package com.functionalinterface.fiConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*
    https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/?ref=rp
 */
public class ConsumerGeekDemo {

    /*
        The Consumer Interface is a part of the java.util.function package which has been introduced since Java 8, to implement functional programming in Java.
        It represents a function which takes in one argument and produces a result. However these kind of functions don’t return any value.
        Hence this functional interface which takes in one generic namely:-

                T: denotes the type of the input argument to the operation

        The lambda expression assigned to an object of Consumer type is used to define its accept() which eventually applies the given operation on its argument.
        Consumers are useful when it not needed to return any value as they are expected to operate via side-effects.

        Functions in Consumer Interface
        The Consumer interface consists of the following two functions:


        void accept(T t)
            This method accepts one value and performs the operation on the given argument
                t– the input argument

            Returns: This method does not return any value.
     */
    public static void main(String args[])
    {

        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer> > modify = list -> {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        // Consumer to display a list of integers
        Consumer<List<Integer> > dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(9);
        list.add(11);

        // using addThen()
        modify.andThen(dispList).accept(list);

        /* --------------------------------------------------------------------------------------------------- */
        // Example 2: To demonstrate when NullPointerException is returned.
        /*
           andThen()
                It returns a composed Consumer wherein the parameterized Consumer will be executed after the first one.
                If evaluation of either function throws an error, it is relayed to the caller of the composed operation.

                Note: The function being passed as the argument should be of type Consumer.

                Syntax:
                    default Consumer <T> andThen(Consumer<? super T> after)

                Parameters:
                        This method accepts a parameter after which is the Consumer to be applied after the current one.
                Return Value:
                        This method returns a composed Consumer that first applies the current Consumer first and then the after operation.
                Exception:
                        This method throws NullPointerException if the after operation is null.
         */

        try {
            // using addThen()
            modify.andThen(null).accept(list);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        /* --------------------------------------------------------------------------------------------------- */
        // Example 3: To demonstrate how an Exception in the after function is returned and handled.

        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer> > modify2 = list2 ->
        {
            // 1 <= list2.size() will throw "java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3"
            for (int i = 0; i <= list2.size(); i++)
                list2.set(i, 2 * list2.get(i));
        };

        // Consumer to display a list of integers
        Consumer<List<Integer> >
                dispList2 = list2 -> list2.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(22);
        list2.add(12);
        list2.add(33);

        // using addThen()
        try {
            dispList2.andThen(modify2).accept(list2);
            ;
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
