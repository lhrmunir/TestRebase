package com.methodreference.advancedArpitMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceUpperCase {

    public static void main(String[] args) {
        List<String> listOfNames = Arrays.asList(new String[] {"Andrew","Mary","Sohan","Deby"});

        // Using lambda expression
        Function<String,String> function1= (name) -> name.toUpperCase();
        ArrayList<String> collect1 = listOfNames.stream().map(function1)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect1);

        // Using method reference
        Function<String,String> function2= String::toUpperCase;
        ArrayList<String> collect2 = listOfNames.stream().map(function2)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect2);
    }
}