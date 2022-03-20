package com.methodreference.advancedArpitMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class PowerFunctions {

    // This is the method we will call in method reference
    public static Integer power(int a)
    {
        return a*a;
    }

    // Function is functional interface which will be target for method reference
    public static List<Integer> calculatePowOf2ForList(List<Integer> list,
                                                       Function<Integer,Integer> function)
    {
        List<Integer> powerNumbers = new ArrayList<>();

        for(Integer num:list)
        {
            Integer powOf2 = function.apply(num);
            powerNumbers.add(powOf2);
        }
        return powerNumbers;
    }

}