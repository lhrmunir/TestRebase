package com.methodreference.advancedArpitMedium;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StaticMethodReferenceMain {

    public static void main(String args[])
    {

        List<Integer> list=Arrays.asList(new Integer[] {1,2,3,4,5});

        // using anonymous class
        Function<Integer,Integer> function1=new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer num) {
                return PowerFunctions.power(num);
            }
        };

        List<Integer> calculatePowForList1 = PowerFunctions.calculatePowOf2ForList(list, function1);
        System.out.println(calculatePowForList1);

        // Using lambda expression
        Function<Integer,Integer> function2 = (num) -> PowerFunctions.power(num);

        List<Integer> calculatePowForList2 = PowerFunctions.calculatePowOf2ForList(list, function2);
        System.out.println(calculatePowForList2);

        // Using Method reference
        Function<Integer,Integer> function3 = PowerFunctions::power;

        List<Integer> calculatePowForList3 = PowerFunctions.calculatePowOf2ForList(list, function3);
        System.out.println(calculatePowForList3);

    }
}