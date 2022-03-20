package com.functionalinterface.fiBiFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/*
        https://www.baeldung.com/java-bifunction-interface

*/
public class BiFunctionDemo {

    public static void main(String [] args)
    {
        BiFunctionDemo bfd = new BiFunctionDemo();

        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        List<String> result = listCombiner(list1, list2, (a, b) -> a + b);

        result.stream().forEach(xp -> System.out.println("xp = " + xp));

        System.out.println("----------------------------------------------");

        List<Double> list1a = Arrays.asList(1.0d, 2.1d, 3.3d);
        List<Float> list2a = Arrays.asList(0.1f, 0.2f, 4f);

        List<Boolean> result1a = listCombiner(list1a, list2a, (a, b) -> a > b);

        result1a.stream().forEach(xp -> System.out.println("xp = " + xp));

        System.out.println("----------------------------------------------");

        /*
            A BiFunction Method Reference
            ==============================
            Let's rewrite the above code with an extracted method and a method reference:
        */
        // List<Boolean> result1b = listCombiner(list1, list2, this::firstIsGreaterThanSecond); // 'com.functionainterface.fiBiFunction.BiFunctionDemo.this' cannot be referenced from a static context
        List<Boolean> result1b = listCombiner(list1a, list2a, bfd::firstIsGreaterThanSecond);


        /*
             List<Boolean> result1c = listCombiner(list1, list2, bfd::firstIsGreaterThanSecond);

             THROWS BELOW EXCEPTION:

                                      Required type                 Provided
                list1:                List<T>                       List<String>
                list2:                List<U>                       List<Integer>
                combiner:             BiFunction<T, U, R>           <method reference>

                reason: no instance(s) of type variable(s) exist so that String conforms to Double
         */
        List<String> lstStrA = Arrays.asList("a", "b", "c", "d", "z", "p");
        List<String> lstStrB = Arrays.asList("a", "x", "c", "d", "e", "q");
        List<Integer> result1c = listCombiner(lstStrA, lstStrB, bfd::sortString);

        System.out.println("Printing comparison of 2 String Arrays:");
        result1c.stream().forEach(ib -> System.out.println("ib = " + ib));

        System.out.println("----------------------------------------------");

        /*
            Composing BiFunctions

            What if we could use method references to do the same thing as our numeric list comparison example?
        */
            List<Double> lstDbl1 = Arrays.asList(1.0d, 2.1d, 3.3d);
            List<Double> lstDbl2 = Arrays.asList(0.1d, 0.2d, 4d);

            List<Integer> lstIntRslt1 = listCombiner(lstDbl1, lstDbl2, Double::compareTo);

            // assertThat(result).containsExactly(1, 1, -1);
            System.out.println("Printiong below lstIntRslt1 elements : ");
            lstIntRslt1.forEach(System.out::println);

            System.out.println("----------------------------------------------");
        /*
            This is close to our example but returns an Integer, rather than the original Boolean. This is because the compareTo method in Double returns Integer.

            We can add the extra behavior we need to achieve our original by using andThen to compose a function. This produces a BiFunction that first does one thing with the two inputs and then performs another operation.

            Next, let's create a function to coerce our method reference Double::compareTo into a BiFunction:

                        private static <T, U, R> BiFunction<T, U, R> asBiFunction(BiFunction<T, U, R> function) {
                            return function;
                        }

            A lambda or method reference only becomes a BiFunction after it has been converted by a method invocation. We can use this helper function to convert our lambda into the BiFunction object explicitly.

            Now, we can use andThen to add behavior on top of the first function:
        */

            List<Boolean> lstBoolRslt1 = listCombiner(lstDbl1, lstDbl2, asBiFunction(Double::compareTo).andThen(i -> i > 0));

            // assertThat(result).containsExactly(true, true, false);
            System.out.println("Printiong below lstBoolRslt1 elements : Composing ByFunction .andThen Demo");
            lstBoolRslt1.forEach(System.out::println);

            System.out.println("----------------------------------------------");
    }

    private static <T, U, R> BiFunction<T, U, R> asBiFunction(BiFunction<T, U, R> function) {
        return function;
    }

    private boolean firstIsGreaterThanSecond(Double a, Float b) {
        return a > b;
    }

    private int sortString(String a, String b) {
        return a.compareTo(b);
    }

    private static <T, U, R> List<R> listCombiner(List<T> list1, List<U> list2, BiFunction<T, U, R> combiner)
    {
        List<R> result = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }
}
