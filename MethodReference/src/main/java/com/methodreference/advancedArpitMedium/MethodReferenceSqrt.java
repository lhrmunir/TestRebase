package com.methodreference.advancedArpitMedium;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceSqrt {

    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(new Integer[] {25,43,52,31,81});

        // Using lambda expression
        Function<Integer,Double> function1= (num) -> Math.sqrt(num);
        List<Double> collect1 = list.stream().map(function1).collect(Collectors.toList());
        System.out.println(collect1);

        // Using method reference
        Function<Integer,Double> function2= Math::sqrt;
        List<Double> collect2 = list.stream().map(function2).collect(Collectors.toList());
        System.out.println(collect2);
    }
}
