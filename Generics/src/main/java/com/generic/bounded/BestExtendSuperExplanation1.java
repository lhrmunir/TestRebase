package com.generic.bounded;

import java.util.*;
import java.util.stream.Collectors;

/*
    BELOW LINKS ARE USED IN THIS CLASS:

    [BEST] - https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
    [GOOD] - https://stackoverflow.com/questions/2723397/what-is-pecs-producer-extends-consumer-super
*/
public class BestExtendSuperExplanation1 {

    public static void main(String [] args) {


        // Source
        List<Integer> intList = Arrays.asList(1,2,3);
        List<Double> doubleList = Arrays.asList(2.78,3.14);
        List<Number> numList = Arrays.asList(1,2,2.78,3.14,5);

        // Destination
        List<Integer> intList2 = new ArrayList<>();
        List<Double> doublesList2 = new ArrayList<>();
        List<Number> numList2 = new ArrayList<>();
        List<Number> numList2d = new ArrayList<>();

        /*
            Collections.copy(List<? super T> dest, List<? extends T> src)
            src -- contains elements of type T or its subtypes.
            dest -- accepts elements, so defined to use T or its supertypes.
        */

        // Works
        copyElements1(intList, intList2);         // from int to int
        // --- OR --
        Collections.copy(intList, intList2);

        copyElements1(doubleList, doublesList2);  // from double to double
        // --- OR --
        Collections.copy(doubleList, doublesList2);

/*

        ERROR EXAMPLES BELOW

*/

        // Let's try to copy intList to its supertype
        // copyElements1(intList, numList2); // ERROR, METHOD SIGNATURE JUST SAYS  "T"

        /*
            and here the compiler is given two types: Integer and Number,

            so which one shall it be?

            PECS to the rescue!
        */
        copyElements2(intList, numList2);  // possible

        // copyElements2(numList2, intList);  // ERROR CASE

        // --- OR --
        // Collections.copy(intList, numList2);  // ERROR CASE


        copyElements2(doubleList, numList2d);  // from double to double

        /*
                Collections.copy(doubleList, numList2d);  // ERROR CASE


                                Required type           Provided
                dest:           List<? super T>         List<Double>
                src:            List<? extends T>       List<Number>
                ERROR REASON : no instance(s) of type variable(s) exist so that Number conforms to Double

                PLEASE KEEP IN MIND BELOW:

                            Collections.copy(List<? super T> dest, List<? extends T> src)

                            src -- contains elements of type T or its subtypes.
                            dest -- accepts elements, so defined to use T or its supertypes.
        */

        /*  ----------- ERROR CASE BELOW -------------

            copyElements2(numList2d, doubleList);  // ERROR CASE

                    Required type               Provided
            src:    Collection<? extends T>     List<Number>
            dest:   Collection<? super T>       List<Double>

            ERROR REASON: no instance(s) of type variable(s) exist so that Number conforms to Double

        */



    }


    static <T> void copyElements1(Collection<T> src, Collection<T> dest)
    {
        System.out.printf( "\n [BEFORE COPYING] inside copyElements1() : src = %s ", format(src));
        System.out.printf( "\n [BEFORE COPYING] inside copyElements1() : dest = %s ", format(dest));

        for(T n : src)
        {
            dest.add(n);
        }

        System.out.printf( "\n [AFTER COPYING] inside copyElements1() : src = %s ", format(src));
        System.out.printf( "\n [AFTER COPYING] inside copyElements1() : dest = %s ", format(dest));
    }

    // copy Integer (? extends T) to its supertype (Number is super of Integer)
    private static <T> void copyElements2(Collection<? extends T> src, Collection<? super T> dest)
    {
        System.out.printf( "\n [BEFORE COPYING] inside copyElements2() : src = %s ", format(src));
        System.out.printf( "\n [BEFORE COPYING] inside copyElements2() : dest = %s ", format(dest));

        for (T n : src)
        {
            dest.add(n);
        }

        System.out.printf( "\n [AFTER COPYING] inside copyElements2() : src = %s ", format(src));
        System.out.printf( "\n [AFTER COPYING] inside copyElements2() : dest = %s ", format(dest));
    }

    // copy Integer (? extends T) to its supertype (Number is super of Integer)
//    private static <T> void copyElements3(Collection<? extends T> src, Collection<? super T> dest)
//    {
//        System.out.printf( "\n [BEFORE COPYING] inside copyElements2() : src = %s ", format(src));
//        System.out.printf( "\n [BEFORE COPYING] inside copyElements2() : dest = %s ", format(dest));
//
//        for (T n : src)
//        {
//            dest.add(n);
//        }
//
//        System.out.printf( "\n [AFTER COPYING] inside copyElements2() : src = %s ", format(src));
//        System.out.printf( "\n [AFTER COPYING] inside copyElements2() : dest = %s ", format(dest));
//    }
    /*
        With java 8 streams and collectors can be printed  easily:
    */
    private static String format(Collection<?> c) {
        String s = c.stream().map(Object::toString).collect(Collectors.joining(","));
        return String.format("[%s]", s);
    }

}
